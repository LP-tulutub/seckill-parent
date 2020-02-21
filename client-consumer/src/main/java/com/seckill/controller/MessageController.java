package com.seckill.controller;

import com.seckill.feign.MessageFeign;
import com.seckill.pojo.MessageUser;
import com.seckill.pojo.SecKillMessage;
import com.seckill.rabbitmq.SecKillSendService;
import com.seckill.result.ResultGeekQ;
import com.seckill.service.SecKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;

import static com.seckill.enums.ResultStatus.MIAO_SHA_OVER;
import static com.seckill.enums.ResultStatus.REPEATE_MIAOSHA;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageFeign messageFeign;
    @Autowired
    private SecKillService secKillService;
    @Resource
    private SecKillSendService secKillSendService;

    private HashMap<Long, Boolean> localOverMap = new HashMap<>();

    /**
     * 消息中心
     * @param model
     * @param userid
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, long userid){

        List<MessageUser> data = this.messageFeign.selByUserId(userid).getData();

        model.addAttribute("message", data);
        model.addAttribute("userid", data.get(0).getUserid());
        return "message_list";
    }

    @RequestMapping("/do_seckill")
    @ResponseBody
    public ResultGeekQ<Integer> secKill(long goodsId, HttpServletRequest req){
        ResultGeekQ<Integer> result = ResultGeekQ.build();
        String userId = req.getAttribute("userId").toString() ;
        String secKillId = userId + goodsId;
        //1.是否已经秒杀到
        boolean bl = this.secKillService.checkSecKill(secKillId);
        if (bl){
            result.withError(REPEATE_MIAOSHA.getCode(), REPEATE_MIAOSHA.getMessage());
            return result;
        }
        //2.当商品已经被秒杀完时，内存标记，减少redis访问
        boolean bl2 = localOverMap.containsKey(goodsId);
        if (bl2) {
            result.withError(MIAO_SHA_OVER.getCode(), MIAO_SHA_OVER.getMessage());
            return result;
        }
        //3.预见库存，步骤2需要此步骤
        boolean bl3 = this.secKillService.checkRepertory(goodsId);
        if (!bl3){
            localOverMap.put(goodsId, true);
            result.withError(MIAO_SHA_OVER.getCode(), MIAO_SHA_OVER.getMessage());
            return result;
        }
        //4.发送信息
        SecKillMessage secKillMessage = new SecKillMessage(Long.parseLong(userId), goodsId);
        Message msg = MessageBuilder.withPayload(secKillMessage).build();
        this.secKillSendService.sendMessage().send(msg);
        return result;
    }

}

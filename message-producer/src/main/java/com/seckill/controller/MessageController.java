package com.seckill.controller;

import com.seckill.enums.ResultStatus;
import com.seckill.mapper.MessageMapper;
import com.seckill.pojo.MessageUser;
import com.seckill.result.ResultGeekQ;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Resource
    private MessageMapper messageMapper;

    @RequestMapping("/selByUserId/{id}")
    public ResultGeekQ<List<MessageUser>> selByUserId(@PathVariable long id){
        List<MessageUser> list = this.messageMapper.selByUserId(id);

        ResultGeekQ<List<MessageUser>> result = ResultGeekQ.build(ResultStatus.SUCCESS.getMessage());
        result.setData(list);

        return result;
    }

}

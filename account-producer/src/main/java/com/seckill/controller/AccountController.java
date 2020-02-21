package com.seckill.controller;

import com.seckill.mapper.AdminMapper;
import com.seckill.mapper.MiaoshaUserMapper;
import com.seckill.pojo.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AdminMapper adminMapper;
    @Resource
    private MiaoshaUserMapper miaoshaUserMapper;

    @RequestMapping("/login")
    public Object login(@RequestBody Account account){
        String username = account.getUsername();
        Object object = null;
        if (!username.equals("root")){
            MiaoshaUserExample miaoshaUserExample = new MiaoshaUserExample();
            miaoshaUserExample.createCriteria()
                    .andNicknameEqualTo(account.getUsername())
                    .andPasswordEqualTo(account.getPassword());
            List<MiaoshaUser> users = this.miaoshaUserMapper.selectByExample(miaoshaUserExample);
            object = users.get(0);

        }else {
            AdminExample adminExample = new AdminExample();
            adminExample.createCriteria()
                    .andNameEqualTo(account.getUsername())
                    .andPasswordEqualTo(account.getPassword());
            List<Admin> admins = this.adminMapper.selectByExample(adminExample);
            object = admins.get(0);
        }
        return object;
    }

    @Transactional
    @RequestMapping("/register")
    public int register(@RequestBody MiaoshaUser user){
        //判断是否已经注册
        MiaoshaUserExample miaoshaUserExample = new MiaoshaUserExample();
        miaoshaUserExample.createCriteria().andNicknameEqualTo(user.getNickname());
        List<MiaoshaUser> key = this.miaoshaUserMapper.selectByExample(miaoshaUserExample);
        if (key!=null && !key.equals(new ArrayList<>())){
            return 2;
        }
        //没有注册就注册
        Date date = new Date();
        user.setRegisterDate(date);
        int insI = this.miaoshaUserMapper.insertSelective(user);
        return insI;
    }

}

package com.seckill.mapper;

import com.seckill.pojo.MessageUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MessageMapper {

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "miaoshaMessage", column = "messageid", one = @One(select = "com.seckill.mapper.messageSecKillMapper.selByMessageId")),
    })
    @Select("select * from miaosha_message_user where userid=#{id}")
    List<MessageUser> selByUserId(long id);

}

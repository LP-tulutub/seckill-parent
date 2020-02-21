package com.seckill.mapper;

import com.seckill.pojo.MiaoshaMessage;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface messageSecKillMapper {

    @Select("select * from miaosha_message where messageid=#{messageId}")
    List<MiaoshaMessage> selByMessageId(long messageId);
}

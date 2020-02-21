package com.seckill.pojo;

import java.io.Serializable;
import java.util.List;

public class MessageUser extends MiaoshaMessageUser implements Serializable {

    private MiaoshaMessage miaoshaMessage;

    public MessageUser() {
    }

    public MiaoshaMessage getMiaoshaMessage() {
        return miaoshaMessage;
    }

    public void setMiaoshaMessage(MiaoshaMessage miaoshaMessage) {
        this.miaoshaMessage = miaoshaMessage;
    }
}

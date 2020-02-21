package com.seckill.pojo;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SecKillMessage implements Serializable {
    private long userId;
    private long goodsId;

}

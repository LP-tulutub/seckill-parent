package com.seckill.test;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        HashMap<Long, Boolean> localOverMap = new HashMap<>();
        boolean bl2 = localOverMap.containsKey("2");
        System.out.println(bl2);

    }
}

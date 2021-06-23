package com.holun.utils;

import java.util.UUID;

public class IDUtil {

    //随机获取UUID
    public static String getId() {
        //UUID是通用唯一识别码（Universally Unique Identifier）
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}

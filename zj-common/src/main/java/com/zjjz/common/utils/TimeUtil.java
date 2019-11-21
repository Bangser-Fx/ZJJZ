package com.zjjz.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author bangser
 * @version 1.0
 * @date 2019-10-31 22:00
 **/
public class TimeUtil {


    public static String getNow() {
        LocalDateTime dateTime = LocalDateTime.now();
        //格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(dateTime);
        return format;
    }
}

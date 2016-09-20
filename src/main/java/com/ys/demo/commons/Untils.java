package com.ys.demo.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangshe on 2016/9/20.
 */
public class Untils {
    public static String getNowTime() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:ss:dd");
        Date date = new Date();
        return  dateFormat.format(date);
    }

}

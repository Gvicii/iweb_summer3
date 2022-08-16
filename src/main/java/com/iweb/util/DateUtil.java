package com.iweb.util;
// 日期类型转换
// Date转成 Timestamp
// mysql中只支持datetime类型的字段
//jdbc只能通过Timestmap类去获取
import java.sql.Timestamp;
import java.util.Date;

public class DateUtil {
    public static Timestamp d2t(Date d){
        if(d==null){
            return null;
        }
        return new Timestamp(d.getTime());
    }
    public static Date t2d(Timestamp t){
        if(t==null){
            return null;
        }
        return new Date(t.getTime());
    }
}

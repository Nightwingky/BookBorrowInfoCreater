package com.dod.nightwingky.getRandomBorrowInfo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomTimestamp {

    //生成一个给定时间区间内的随机时间戳
    public static Timestamp randomDate(String beginDate, String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(beginDate);  // 构造开始日期
            Date end = format.parse(endDate);  // 构造结束日期
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
            if(start.getTime() >= end.getTime()){
                return null;
            }

            long date = random(start.getTime(),end.getTime());

            Date mDate = new Date(date);

            String dateString  = mDate.toString();
            SimpleDateFormat sfEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sfStart = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",java.util.Locale.ENGLISH) ;
            dateString = sfEnd.format(sfStart.parse(dateString));

            return Timestamp.valueOf(dateString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }

}

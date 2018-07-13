package com.dod.nightwingky.getRandomBorrowInfo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeStampConvert {

    public static Timestamp addHour(Timestamp t, int hour) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;

        date = sdf.parse(String.valueOf(t));

        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.add(Calendar.HOUR_OF_DAY, hour);
        t = Timestamp.valueOf(sdf.format(ca.getTime()));

        return t;
    }
}

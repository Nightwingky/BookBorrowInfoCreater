package com.dod.nightwingky;

import com.dod.nightwingky.getRandomBorrowInfo.GetBorrowInfo;
import com.dod.nightwingky.vo.BorrowInfoVO;
import com.dod.nightwingky.vo.ReturnInfoVO;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException {
	// write your code here
        GetBorrowInfo.procedure();

        System.out.println("***********************");
        for (BorrowInfoVO b : GetBorrowInfo.borrowList) {
            System.out.println(b);
        }
        System.out.println("***********************");
        for (ReturnInfoVO r : GetBorrowInfo.returnList) {
            System.out.println(r);
        }
    }
}

//        BorrowDAO borrowDAO = new BorrowDAO();

//        System.out.println(RandomTimestamp.randomDate("2017-01-01", "2018-01-01"));
//
//        System.out.println(MyConst.book_id);
//        borrowDAO.addInfo(
//                new BorrowInfoVO(
//                        1, 1, new Timestamp(System.currentTimeMillis()),
//                        new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()), 1
//                )
//        );



//        System.out.println("***********************");
//        for (BorrowInfoVO b : GetBorrowInfo.borrowList) {
//            System.out.println(b);
//        }
//        System.out.println("***********************");
//        for (ReturnInfoVO r : GetBorrowInfo.returnList) {
//            System.out.println(r);
//        }
//        System.out.println(RandomTimestamp.randomDate(
//                String.valueOf(GetBorrowInfo.startTime),
//                String.valueOf(TimeStampConvert.addHour(GetBorrowInfo.startTime, 1)))
//        );

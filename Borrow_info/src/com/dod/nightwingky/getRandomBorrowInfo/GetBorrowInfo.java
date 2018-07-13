package com.dod.nightwingky.getRandomBorrowInfo;

import com.dod.nightwingky.dao.BorrowDAO;
import com.dod.nightwingky.myConst.MyConst;
import com.dod.nightwingky.vo.BookVO;
import com.dod.nightwingky.vo.BorrowInfoVO;
import com.dod.nightwingky.vo.ReturnInfoVO;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GetBorrowInfo {

    //规定模拟开始和结束时间点
    public static Timestamp startTime = Timestamp.valueOf("2018-01-01 00:00:00");
    public static Timestamp endTime = Timestamp.valueOf("2018-07-01 00:00:00");

    //创建2个List存储借阅信息和归还信息
    public static List<BorrowInfoVO> borrowList = new ArrayList<BorrowInfoVO>();
    public static List<ReturnInfoVO> returnList = new ArrayList<ReturnInfoVO>();

    //创建List存储正在借阅中的图书
    private static List<BookVO> borrowingList = new ArrayList<BookVO>();

    /**
        1. 设定规则为每一小时随机产生一笔借书订单
        2. 预计归还日期随机生成
        3. 实际归还日期为预计归还日期+- 小时
     */
    public static void procedure() throws ParseException, SQLException {

        //创建时间轴，初始值为开始时间
        Timestamp timeLine = startTime;

        //创建每笔随机借阅信息的时间点
        Timestamp startTimePoint = null;
        Timestamp finishTimePoint = null;
        Timestamp randomTimePoint = null;

        //创建预计和实际归还时间点
        Timestamp expectReturnTimePoint = null;
        Timestamp actualReturnTimePoint = null;

        //创建选出借阅的图书
        BookVO bookVO;

        //创建本订单的员工id，图书id，borrow_id
        int stuff_id;
        int book_id;
        int borrow_id = 1;

        //创建借阅，归还信息
        BorrowInfoVO borrowInfoVO;
        ReturnInfoVO returnInfoVO;

        Random random = new Random();

        while(true) {

            System.out.println("-----timeLine: " + timeLine + "------");
            System.out.println(" * BorrowId: " + borrow_id);

            //生成一小时中的随机借书时间点
            startTimePoint = timeLine;
            finishTimePoint = TimeStampConvert.addHour(timeLine, 1);
            randomTimePoint = RandomTimestamp.randomDate(String.valueOf(startTimePoint), String.valueOf(finishTimePoint));
            //选出可供借阅的图书，生成借阅图书id，其中0表示可借阅1表示不可借阅
            while (true) {
                bookVO = MyConst.book_id.get(random.nextInt(MyConst.book_id.size()));
                if(bookVO.getStatus() == 0) {
                    book_id = bookVO.getBook_id();
                    bookVO.setBorrow_id(borrow_id);
                    break;
                }
            }

            //修改图书信息List中该图书的状态为不可借阅
            for (BookVO b : MyConst.book_id) {
                if(b.getBook_id() == bookVO.getBook_id()) {
                    b.setStatus(1);
                }
            }

            //生成员工id
            stuff_id = random.nextInt(MyConst.stuff_id.size()) + 1;
            //生成预计归还日期
            expectReturnTimePoint = TimeStampConvert.addHour(randomTimePoint, random.nextInt(5) + 5);

            //将生成的借阅日期加入借阅信息List
            borrowInfoVO = new BorrowInfoVO(stuff_id, book_id, randomTimePoint, expectReturnTimePoint, 1, 0);
            borrowList.add(borrowInfoVO);
//            BorrowDAO.addBorrowInfo(borrowInfoVO);
//            System.out.println(" + borrow: " + borrowInfoVO);

            //生成实际归还日期，设定为预计归还日期+-小时
            actualReturnTimePoint = TimeStampConvert.addHour(expectReturnTimePoint, random.nextInt(6) - 3);

            //将正在借阅图书信息加入正在借阅图书信息列表
            bookVO.setActualReturn(actualReturnTimePoint);
            bookVO.setStatus(1);
            borrowingList.add(bookVO);


            /**
             遍历正在借阅图书信息列表
            for (BookVO b : borrowingList) {
                //寻找该时间段是否有到期要还的图书
                if(b.getActualReturn().after(timeLine) &&
                        b.getActualReturn().before(TimeStampConvert.addHour(timeLine, 1)) && b.getBook_id() == 1) {
                    //还书
                    b.setStatus(0);
                    //修改图书信息List中该图书的状态为可借阅
                    for (int i = 0; i < MyConst.book_id.size(); i++) {
                        if(MyConst.book_id.get(i).getBook_id() == bookVO.getBook_id()) {
                            MyConst.book_id.get(i).setStatus(0);
                        }
                    }

                    returnInfoVO = new ReturnInfoVO(b.getBorrow_id(), b.getActualReturn(), 2);
                    //将还书信息加入还书列表
                    returnList.add(returnInfoVO);
                    System.out.println("return: " + returnInfoVO);
                    //将借书信息列表中的对应借阅记录状态改为complete
                    //TODO:

                    //将本书从正在借阅列表中删除
//                    b.setStatus(2);
                }
            }
            */

            //遍历正在借阅图书信息列表
            for (int i = 0; i < borrowingList.size(); i++) {

                BookVO b = borrowingList.get(i);

                if(b.getActualReturn().after(timeLine) &&
                        b.getActualReturn().before(TimeStampConvert.addHour(timeLine, 1)) &&
                        b.getStatus() == 1) {
                    //还书
                    borrowingList.get(i).setStatus(0);

                    //修改图书信息List中该图书的状态为可借阅
                    for (int j = 0; j < MyConst.book_id.size(); j++) {
                        if (MyConst.book_id.get(j).getBook_id() == bookVO.getBook_id()) {
                            MyConst.book_id.get(j).setStatus(0);
                        }
                    }
                    //生成还书信息
                    returnInfoVO = new ReturnInfoVO(b.getBorrow_id(), b.getActualReturn(), 2);
                    //将还书信息加入还书列表
                    returnList.add(returnInfoVO);
//                    System.out.println(" - return: " + returnInfoVO);
//                    BorrowDAO.addReturnInfo(returnInfoVO);
                }

            }

            timeLine = TimeStampConvert.addHour(timeLine, 1);
            borrow_id ++;

            if(timeLine.after(endTime)) {
                break;
            }
        }
    }
}

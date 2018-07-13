package com.dod.nightwingky.myConst;

import com.dod.nightwingky.vo.BookVO;

import java.util.ArrayList;
import java.util.List;

public class MyConst {

    //员工信息
    public static List<Integer> stuff_id = new ArrayList<>();
    //图书信息(图书id, 借阅状态), 其中借阅状态0代表可借阅, 1代表不可借阅
    public static List<BookVO> book_id = new ArrayList<BookVO>();

    static {
        for(int i = 1; i <= 30; i++) {
            stuff_id.add(i);
        }
        for(int i = 1; i <= 21; i++) {
            book_id.add(new BookVO(i, 0));
        }
    }
}

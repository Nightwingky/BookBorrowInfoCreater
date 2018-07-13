package com.dod.nightwingky.vo;

import java.sql.Timestamp;

public class BookVO {

    private int book_id;
    private int status = 0;

    private int borrow_id;
    private Timestamp actualReturn;

    public BookVO(int book_id, int status) {
        this.book_id = book_id;
        this.status = status;
    }

    public Timestamp getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(Timestamp actualReturn) {
        this.actualReturn = actualReturn;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "book_id=" + book_id +
                ", status=" + status +
                ", borrow_id=" + borrow_id +
                ", actualReturn=" + actualReturn +
                '}';
    }
}

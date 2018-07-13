package com.dod.nightwingky.vo;

import java.sql.Timestamp;

public class BorrowInfoVO {

    private int stuff_id;
    private int book_id;
    private Timestamp borrow_date;
    private Timestamp expect_return;
    private int status_id;
    private int isComplete;

    public BorrowInfoVO(int stuff_id, int book_id, Timestamp borrow_date, Timestamp expect_return, int status_id, int isComplete) {
        this.stuff_id = stuff_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.expect_return = expect_return;
        this.status_id = status_id;
        this.isComplete = isComplete;
    }

    public int getStuff_id() {
        return stuff_id;
    }

    public void setStuff_id(int stuff_id) {
        this.stuff_id = stuff_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public Timestamp getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Timestamp borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Timestamp getExpect_return() {
        return expect_return;
    }

    public void setExpect_return(Timestamp expect_return) {
        this.expect_return = expect_return;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(int isComplete) {
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        return "BorrowInfoVO{" +
                "stuff_id=" + stuff_id +
                ", book_id=" + book_id +
                ", borrow_date=" + borrow_date +
                ", expect_return=" + expect_return +
                ", status_id=" + status_id +
                ", isComplete=" + isComplete +
                '}';
    }
}


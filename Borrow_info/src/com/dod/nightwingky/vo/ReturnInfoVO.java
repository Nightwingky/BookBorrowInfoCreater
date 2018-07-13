package com.dod.nightwingky.vo;

import java.sql.Timestamp;

public class ReturnInfoVO {

    private int borrow_id;
    private Timestamp actual_return;
    private int status_id;

    public ReturnInfoVO(int borrow_id, Timestamp actual_return, int status_id) {
        this.borrow_id = borrow_id;
        this.actual_return = actual_return;
        this.status_id = status_id;
    }

    public int getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
    }

    public Timestamp getActual_return() {
        return actual_return;
    }

    public void setActual_return(Timestamp actual_return) {
        this.actual_return = actual_return;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    @Override
    public String toString() {
        return "ReturnInfoVO{" +
                "borrow_id=" + borrow_id +
                ", actual_return=" + actual_return +
                ", status_id=" + status_id +
                '}';
    }
}

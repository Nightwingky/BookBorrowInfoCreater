package com.dod.nightwingky.vo;

public class StuffInfoVO {

    private int stuff_id;
    private String stuff_name;
    private String gender;
    private int department_id;
    private String mobile;

    public StuffInfoVO(int stuff_id, String stuff_name, String gender, int department_id, String mobile) {
        this.stuff_id = stuff_id;
        this.stuff_name = stuff_name;
        this.gender = gender;
        this.department_id = department_id;
        this.mobile = mobile;
    }

    public int getStuff_id() {
        return stuff_id;
    }

    public void setStuff_id(int stuff_id) {
        this.stuff_id = stuff_id;
    }

    public String getStuff_name() {
        return stuff_name;
    }

    public void setStuff_name(String stuff_name) {
        this.stuff_name = stuff_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "StuffInfoVO{" +
                "stuff_id=" + stuff_id +
                ", stuff_name='" + stuff_name + '\'' +
                ", gender='" + gender + '\'' +
                ", department_id=" + department_id +
                ", mobile=" + mobile +
                '}';
    }
}

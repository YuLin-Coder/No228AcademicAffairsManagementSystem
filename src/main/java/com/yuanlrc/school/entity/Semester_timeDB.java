package com.yuanlrc.school.entity;

import java.io.Serializable;

public class Semester_timeDB implements Serializable {
    private Integer stid;
    private String stname;

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }
}

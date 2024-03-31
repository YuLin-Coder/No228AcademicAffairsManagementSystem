package com.yuanlrc.school.entity;

import java.io.Serializable;

public class Stu_examDB implements Serializable {
    private Integer seid;
    private Integer sid;
    private Integer scid;
    private double normalexam;
    private double testexam;
    private double sumexam;
    private Integer stid;

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public double getNormalexam() {
        return normalexam;
    }

    public void setNormalexam(double normalexam) {
        this.normalexam = normalexam;
    }

    public double getTestexam() {
        return testexam;
    }

    public void setTestexam(double testexam) {
        this.testexam = testexam;
    }

    public double getSumexam() {
        return sumexam;
    }

    public void setSumexam(double sumexam) {
        this.sumexam = sumexam;
    }

    public Integer getStid() {
        return stid;
    }

    public void setStid(Integer stid) {
        this.stid = stid;
    }
}

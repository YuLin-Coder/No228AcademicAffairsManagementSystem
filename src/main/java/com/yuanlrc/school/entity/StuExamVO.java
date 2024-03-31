package com.yuanlrc.school.entity;

public class StuExamVO {
    private Integer scid;
    private Integer sid;
    private Integer cid;
    private String stuid;
    private Integer tid;
    private String sname;
    private String cname;
    private Integer classid;
    private String classname;
    private Integer stime;
    private double normalexam;
    private  double testexam;
    private double sumexam;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getStime() {
        return stime;
    }

    public void setStime(Integer stime) {
        this.stime = stime;
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

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}

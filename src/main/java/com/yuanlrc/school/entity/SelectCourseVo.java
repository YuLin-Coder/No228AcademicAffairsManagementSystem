package com.yuanlrc.school.entity;
/**
 * 课程表，课程类型表，教师授课表，教师表，星期表，作息时间表,学生表
 */
public class SelectCourseVo {
    private Integer cid;//课程编号
    private String cname;//课程名称
    private Integer ccredit;//学分
    private String ctname;//课程类型
    private String studytype;//选修
    private String tname;//教授教师
    private Integer cselcount;//已选人数
    private Integer cmaxcount;//限定人数
    private String wname;//周
    private String timeinterval;//天
    private String schname;//时段
    private String stuid; //学号

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getStudytype() {
        return studytype;
    }

    public void setStudytype(String studytype) {
        this.studytype = studytype;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getCselcount() {
        return cselcount;
    }

    public void setCselcount(Integer cselcount) {
        this.cselcount = cselcount;
    }

    public Integer getCmaxcount() {
        return cmaxcount;
    }

    public void setCmaxcount(Integer cmaxcount) {
        this.cmaxcount = cmaxcount;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getTimeinterval() {
        return timeinterval;
    }

    public void setTimeinterval(String timeinterval) {
        this.timeinterval = timeinterval;
    }

    public String getSchname() {
        return schname;
    }

    public void setSchname(String schname) {
        this.schname = schname;
    }
}

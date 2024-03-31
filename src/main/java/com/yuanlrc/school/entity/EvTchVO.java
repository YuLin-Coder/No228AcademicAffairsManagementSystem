package com.yuanlrc.school.entity;

import java.util.Date;

/**
 * 教评表
 */
public class EvTchVO {
    private Integer eid;
    private String stuid;
    private String tchid;
    private Integer erexam;
    private Integer erstate;
    private Integer tid;
    private String tname;
    private String tgender;
    private Date tbirthday;
    private Integer pid;
    private String tnation;
    private String tcardid;
    private String tphone;
    private String taddress;
    private Integer tchstate;
    private Integer exam;
    private Integer count;
    private Integer mid;
    private Integer teid; //教师成绩编号
    private Integer pcount; //评教人数
    private Date tetime; //成绩时间
    private Integer semester; //学期
    private Integer isDel; //逻辑删除

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getTchid() {
        return tchid;
    }

    public void setTchid(String tchid) {
        this.tchid = tchid;
    }

    public Integer getErexam() {
        return erexam;
    }

    public void setErexam(Integer erexam) {
        this.erexam = erexam;
    }

    public Integer getErstate() {
        return erstate;
    }

    public void setErstate(Integer erstate) {
        this.erstate = erstate;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTgender() {
        return tgender;
    }

    public void setTgender(String tgender) {
        this.tgender = tgender;
    }

    public Date getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(Date tbirthday) {
        this.tbirthday = tbirthday;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTnation() {
        return tnation;
    }

    public void setTnation(String tnation) {
        this.tnation = tnation;
    }

    public String getTcardid() {
        return tcardid;
    }

    public void setTcardid(String tcardid) {
        this.tcardid = tcardid;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public Integer getTchstate() {
        return tchstate;
    }

    public void setTchstate(Integer tchstate) {
        this.tchstate = tchstate;
    }

    public Integer getExam() {
        return exam;
    }

    public void setExam(Integer exam) {
        this.exam = exam;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getTeid() {
        return teid;
    }

    public void setTeid(Integer teid) {
        this.teid = teid;
    }

    public Integer getPcount() {
        return pcount;
    }

    public void setPcount(Integer pcount) {
        this.pcount = pcount;
    }

    public Date getTetime() {
        return tetime;
    }

    public void setTetime(Date tetime) {
        this.tetime = tetime;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}

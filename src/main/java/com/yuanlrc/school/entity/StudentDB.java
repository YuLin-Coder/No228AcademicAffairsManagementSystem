package com.yuanlrc.school.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 学生表
 */

public class StudentDB implements Serializable {

  private Integer sid; //学生编号
  private String stuid; //学号
  private String sname; //姓名
  private String sgender; //性别
  private Date sbirthday; //出生年月
  private Integer pid; //政治面貌编号
  private String snation; //民族
  private String scardid; //身份证号
  private String sphone; //手机号
  private String saddress; //家庭住址
  private Date entertime; //入学时间
  private Date leavetime; //毕业时间
  private Integer stustate; //学生状态
  private Integer classid; //班级编号
  private Integer isDel; //逻辑删除

  public Integer getSid() {
    return sid;
  }

  public void setSid(Integer sid) {
    this.sid = sid;
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

  public String getSgender() {
    return sgender;
  }

  public void setSgender(String sgender) {
    this.sgender = sgender;
  }

  public Date getSbirthday() {
    return sbirthday;
  }

  public void setSbirthday(Date sbirthday) {
    this.sbirthday = sbirthday;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getSnation() {
    return snation;
  }

  public void setSnation(String snation) {
    this.snation = snation;
  }

  public String getScardid() {
    return scardid;
  }

  public void setScardid(String scardid) {
    this.scardid = scardid;
  }

  public String getSphone() {
    return sphone;
  }

  public void setSphone(String sphone) {
    this.sphone = sphone;
  }

  public String getSaddress() {
    return saddress;
  }

  public void setSaddress(String saddress) {
    this.saddress = saddress;
  }

  public Date getEntertime() {
    return entertime;
  }

  public void setEntertime(Date entertime) {
    this.entertime = entertime;
  }

  public Date getLeavetime() {
    return leavetime;
  }

  public void setLeavetime(Date leavetime) {
    this.leavetime = leavetime;
  }

  public Integer getStustate() {
    return stustate;
  }

  public void setStustate(Integer stustate) {
    this.stustate = stustate;
  }

  public Integer getClassid() {
    return classid;
  }

  public void setClassid(Integer classid) {
    this.classid = classid;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

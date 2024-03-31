package com.yuanlrc.school.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 教师表
 */

public class TeacherDB implements Serializable {

  private Integer tid; //教师编号
  private String tchid; //教师工号
  private String tname; //姓名
  private String tgender; //性别
  private Date tbirthday; //出生年月
  private Integer pid; //政治面貌编号
  private String tnation; //民族
  private String tcardid; //身份证号
  private String tphone; //手机号
  private String taddress; //家庭住址
  private Date entertime; //入职时间
  private Date leavetime; //离职时间
  private Integer tchstate; //教师状态
  private Integer isDel; //逻辑删除

  public Integer getTid() {
    return tid;
  }

  public void setTid(Integer tid) {
    this.tid = tid;
  }

  public String getTchid() {
    return tchid;
  }

  public void setTchid(String tchid) {
    this.tchid = tchid;
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

  public Integer getTchstate() {
    return tchstate;
  }

  public void setTchstate(Integer tchstate) {
    this.tchstate = tchstate;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

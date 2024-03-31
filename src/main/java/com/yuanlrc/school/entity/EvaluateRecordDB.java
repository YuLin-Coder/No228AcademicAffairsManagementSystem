package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 教评记录表
 */

public class EvaluateRecordDB implements Serializable {
  private Integer erid; //记录编号
  private String stuid; //学生学号
  private String tchid; //教师工号
  private Integer erexam; //评教成绩
  private Integer isDel; //逻辑删除

  public Integer getErid() {
    return erid;
  }

  public void setErid(Integer erid) {
    this.erid = erid;
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

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

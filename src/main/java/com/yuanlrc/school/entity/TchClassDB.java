package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 教师班级表
 */

public class TchClassDB implements Serializable {
  private Integer tcsid; //教师班级编号
  private Integer tcid; //教师授课编号
  private Integer tid; //教师编号
  private Integer classid; //班级编号
  private Integer isDel; //逻辑删除

  public Integer getTcid() {
    return tcid;
  }

  public void setTcid(Integer tcid) {
    this.tcid = tcid;
  }

  public Integer getTid() {
    return tid;
  }

  public void setTid(Integer tid) {
    this.tid = tid;
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

  public Integer getTcsid() {
    return tcsid;
  }

  public void setTcsid(Integer tcsid) {
    this.tcsid = tcsid;
  }
}

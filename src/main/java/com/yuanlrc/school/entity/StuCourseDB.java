package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 学生选课表
 */

public class StuCourseDB implements Serializable {

  private Integer scid; //学生选课记录编号
  private Integer sid; //学生编号
  private Integer cid; //课程编号
  private Integer isDel; //逻辑删除

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

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

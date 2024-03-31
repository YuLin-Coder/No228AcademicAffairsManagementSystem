package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 教师授课表
 */

public class TchCourseDB implements Serializable {

  private Integer tcid; //教师授课编号
  private Integer tid; //教师编号
  private Integer cid; //课程编号
  private Integer wid; //授课星期编号
  private Integer schid; //授课时段编号
  private Integer gid; //年级编号
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

  public Integer getCid() {
    return cid;
  }

  public void setCid(Integer cid) {
    this.cid = cid;
  }

  public Integer getWid() {
    return wid;
  }

  public void setWid(Integer wid) {
    this.wid = wid;
  }

  public Integer getSchid() {
    return schid;
  }

  public void setSchid(Integer schid) {
    this.schid = schid;
  }

  public Integer getGid() {
    return gid;
  }

  public void setGid(Integer gid) {
    this.gid = gid;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

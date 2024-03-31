package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 年级表
 */

public class GradeDB implements Serializable {

  private Integer gid; //年级编号
  private String gname; //年级名称
  private Integer gcount; //年级人数
  private Integer mid; //专业编号
  private Integer isDel; //逻辑删除

  public Integer getGid() {
    return gid;
  }

  public void setGid(Integer gid) {
    this.gid = gid;
  }

  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }

  public Integer getGcount() {
    return gcount;
  }

  public void setGcount(Integer gcount) {
    this.gcount = gcount;
  }

  public Integer getMid() {
    return mid;
  }

  public void setMid(Integer mid) {
    this.mid = mid;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

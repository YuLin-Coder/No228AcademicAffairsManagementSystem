package com.yuanlrc.school.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 班级表
 */

public class ClassinfoDB implements Serializable {

  private Integer classid; //班级编号
  private String classname; //班级名称
  private Date begintime; //开班时间
  private Date endtime; //闭班时间
  private Integer ccount; //班级人数
  private Integer gid; //年级编号
  private Integer isDel; //逻辑删除

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

  public Date getBegintime() {
    return begintime;
  }

  public void setBegintime(Date begintime) {
    this.begintime = begintime;
  }

  public Date getEndtime() {
    return endtime;
  }

  public void setEndtime(Date endtime) {
    this.endtime = endtime;
  }

  public Integer getCcount() {
    return ccount;
  }

  public void setCcount(Integer ccount) {
    this.ccount = ccount;
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

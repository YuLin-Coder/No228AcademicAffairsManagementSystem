package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 作息时间表
 */

public class ScheduleDB implements Serializable {

  private Integer schid; //作息时间编号
  private String timeinterval; //时段
  private String schname; //时序
  private String summer; //夏季时间
  private String winter; //冬季时间

  public Integer getSchid() {
    return schid;
  }

  public void setSchid(Integer schid) {
    this.schid = schid;
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

  public String getSummer() {
    return summer;
  }

  public void setSummer(String summer) {
    this.summer = summer;
  }

  public String getWinter() {
    return winter;
  }

  public void setWinter(String winter) {
    this.winter = winter;
  }
}

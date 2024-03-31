package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 课目类型表
 */

public class CourseTypeDB implements Serializable {

  private Integer ctid; //类型编号
  private String ctname; //类型名称

  public Integer getCtid() {
    return ctid;
  }

  public void setCtid(Integer ctid) {
    this.ctid = ctid;
  }

  public String getCtname() {
    return ctname;
  }

  public void setCtname(String ctname) {
    this.ctname = ctname;
  }
}

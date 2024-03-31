package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 系部表
 */

public class DepartmentDB implements Serializable {

  private Integer did; //系部编号
  private String dname; //系部名称
  private Integer dcount; //系部人数
  private Integer isDel; //逻辑删除

  public Integer getDid() {
    return did;
  }

  public void setDid(Integer did) {
    this.did = did;
  }

  public String getDname() {
    return dname;
  }

  public void setDname(String dname) {
    this.dname = dname;
  }

  public Integer getDcount() {
    return dcount;
  }

  public void setDcount(Integer dcount) {
    this.dcount = dcount;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

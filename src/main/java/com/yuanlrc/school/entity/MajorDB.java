package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 专业表
 */

public class MajorDB implements Serializable {

  private Integer mid; //专业编号
  private String mname; //专业名称
  private Integer mcount; //专业人数
  private Integer did; //系部编号
  private Integer isDel; //逻辑删除

  public Integer getMid() {
    return mid;
  }

  public void setMid(Integer mid) {
    this.mid = mid;
  }

  public String getMname() {
    return mname;
  }

  public void setMname(String mname) {
    this.mname = mname;
  }

  public Integer getMcount() {
    return mcount;
  }

  public void setMcount(Integer mcount) {
    this.mcount = mcount;
  }

  public Integer getDid() {
    return did;
  }

  public void setDid(Integer did) {
    this.did = did;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

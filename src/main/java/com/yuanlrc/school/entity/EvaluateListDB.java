package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 教评题目表
 */

public class EvaluateListDB implements Serializable {

  private Integer elid; //题目编号
  private String elcontent; //题目内容

  public Integer getElid() {
    return elid;
  }

  public void setElid(Integer elid) {
    this.elid = elid;
  }

  public String getElcontent() {
    return elcontent;
  }

  public void setElcontent(String elcontent) {
    this.elcontent = elcontent;
  }
}

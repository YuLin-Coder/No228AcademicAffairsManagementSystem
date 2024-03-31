package com.yuanlrc.school.entity;


import java.io.Serializable;

/**
 * 学生成绩表
 */

public class StuExamDB implements Serializable {

  private Integer seid; //学生成绩编号
  private Integer sid; //学生编号
  private Integer scid; //学生选课编号
  private double normalexam; //平时成绩
  private double testexam; //考试成绩
  private double sumexam; //综合成绩
  private Integer stime; //成绩时间
  private Integer studynature; //修读性质0初修1选修
  private Integer isDel; //逻辑删除

  public Integer getSeid() {
    return seid;
  }

  public void setSeid(Integer seid) {
    this.seid = seid;
  }

  public Integer getSid() {
    return sid;
  }

  public void setSid(Integer sid) {
    this.sid = sid;
  }

  public Integer getScid() {
    return scid;
  }

  public void setScid(Integer scid) {
    this.scid = scid;
  }

  public double getNormalexam() {
    return normalexam;
  }

  public void setNormalexam(double normalexam) {
    this.normalexam = normalexam;
  }

  public double getTestexam() {
    return testexam;
  }

  public void setTestexam(double testexam) {
    this.testexam = testexam;
  }

  public double getSumexam() {
    return sumexam;
  }

  public void setSumexam(double sumexam) {
    this.sumexam = sumexam;
  }

  public Integer getStime() {
    return stime;
  }

  public void setStime(Integer stime) {
    this.stime = stime;
  }

  public Integer getStudynature() {
    return studynature;
  }

  public void setStudynature(Integer studynature) {
    this.studynature = studynature;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

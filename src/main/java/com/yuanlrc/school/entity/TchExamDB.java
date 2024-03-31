package com.yuanlrc.school.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 教师成绩表
 */

public class TchExamDB implements Serializable {

  private Integer teid; //教师成绩编号
  private Integer tid; //教师编号
  private double exam; //总成绩
  private Integer pcount; //评教人数
  private Date tetime; //成绩时间
  private Integer semester; //学期
  private Integer isDel; //逻辑删除

  public Integer getTeid() {
    return teid;
  }

  public void setTeid(Integer teid) {
    this.teid = teid;
  }

  public Integer getTid() {
    return tid;
  }

  public void setTid(Integer tid) {
    this.tid = tid;
  }

  public double getExam() {
    return exam;
  }

  public void setExam(double exam) {
    this.exam = exam;
  }

  public Integer getPcount() {
    return pcount;
  }

  public void setPcount(Integer pcount) {
    this.pcount = pcount;
  }

  public Date getTetime() {
    return tetime;
  }

  public void setTetime(Date tetime) {
    this.tetime = tetime;
  }

  public Integer getSemester() {
    return semester;
  }

  public void setSemester(Integer semester) {
    this.semester = semester;
  }

  public Integer getIsDel() {
    return isDel;
  }

  public void setIsDel(Integer isDel) {
    this.isDel = isDel;
  }
}

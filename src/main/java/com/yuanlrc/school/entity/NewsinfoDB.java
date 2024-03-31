package com.yuanlrc.school.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 新闻表
 */

public class NewsinfoDB implements Serializable {

  private Integer nid; //新闻编号
  private String ntitle; //新闻标题
  private String ncontent; //新闻内容
  private String nauthor; //新闻编辑人
  private Date ntime; //发布时间
  private String nimg; //新闻标题图

  public Integer getNid() {
    return nid;
  }

  public void setNid(Integer nid) {
    this.nid = nid;
  }

  public String getNtitle() {
    return ntitle;
  }

  public void setNtitle(String ntitle) {
    this.ntitle = ntitle;
  }

  public String getNcontent() {
    return ncontent;
  }

  public void setNcontent(String ncontent) {
    this.ncontent = ncontent;
  }

  public String getNauthor() {
    return nauthor;
  }

  public void setNauthor(String nauthor) {
    this.nauthor = nauthor;
  }

  public Date getNtime() {
    return ntime;
  }

  public void setNtime(Date ntime) {
    this.ntime = ntime;
  }

  public String getNimg() {
    return nimg;
  }

  public void setNimg(String nimg) {
    this.nimg = nimg;
  }
}

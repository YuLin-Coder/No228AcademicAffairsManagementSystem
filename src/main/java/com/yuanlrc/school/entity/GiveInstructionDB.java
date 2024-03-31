package com.yuanlrc.school.entity;


import java.util.Date;

public class GiveInstructionDB {

  private int giid;
  private int tid;
  private int cid;
  private Date gitime;
  private String gaddress;
  private int classid;


  public int getGiid() {
    return giid;
  }

  public void setGiid(int giid) {
    this.giid = giid;
  }


  public int getTid() {
    return tid;
  }

  public void setTid(int tid) {
    this.tid = tid;
  }


  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }


  public Date getGitime() {
    return gitime;
  }

  public void setGitime(Date gitime) {
    this.gitime = gitime;
  }


  public String getGaddress() {
    return gaddress;
  }

  public void setGaddress(String gaddress) {
    this.gaddress = gaddress;
  }


  public int getClassid() {
    return classid;
  }

  public void setClassid(int classid) {
    this.classid = classid;
  }

}

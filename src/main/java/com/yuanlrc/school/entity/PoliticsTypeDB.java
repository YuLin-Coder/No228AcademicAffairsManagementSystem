package com.yuanlrc.school.entity;

import java.io.Serializable;

/**
 * 政治面貌表
 */

public class PoliticsTypeDB implements Serializable {

  private Integer pid; //政治面貌编号
  private String pname; //政治面貌名称

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }
}

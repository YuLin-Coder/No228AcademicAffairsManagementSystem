package com.yuanlrc.school.entity;

import java.io.Serializable;
import java.util.Date;


public class TchCourseVO implements Serializable {
    private Integer cid; //课目编号
    private String cname; //课目名称
    private String classname; //班级名称
    private String mname; //专业名称
    private String tname; //姓名
    private String gname; //年级名称
    private String wname; //星期名
    private String walias; //周名
    private String schname; //时序
    private double ccredit; //学分
    private double cperiod; //学时
    private Integer cstate; //课目状态
    private Integer cselcount; //已选人数
    private Integer cmaxcount; //限定人数
    private String studytype; //修读类型
    private Integer ctid; //课目类型编号
    private Integer mid; //专业编号
    private Integer mcount; //专业人数
    private Integer did; //系部编号
    private Integer tcsid; //教师班级编号
    private Integer tcid; //教师授课编号
    private Integer tid; //教师编号
    private Integer wid; //授课星期编号
    private Integer schid; //授课时段编号
    private Integer gid; //年级编号
    private Integer classid; //班级编号
    private String tchid; //教师工号
    private String tgender; //性别
    private Date tbirthday; //出生年月
    private Integer pid; //政治面貌编号
    private String tnation; //民族
    private String tcardid; //身份证号
    private String tphone; //手机号
    private String taddress; //家庭住址
    private Date entertime; //入职时间
    private Date leavetime; //离职时间
    private Integer tchstate; //教师状态
    private Date begintime; //开班时间
    private Date endtime; //闭班时间
    private Integer ccount; //班级人数
    private Integer gcount; //年级人数
    private String timeinterval; //时段
    private String summer; //夏季时间
    private String winter; //冬季时间
    private Integer isDel; //逻辑删除

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getWalias() {
        return walias;
    }

    public void setWalias(String walias) {
        this.walias = walias;
    }

    public String getSchname() {
        return schname;
    }

    public void setSchname(String schname) {
        this.schname = schname;
    }

    public double getCcredit() {
        return ccredit;
    }

    public void setCcredit(double ccredit) {
        this.ccredit = ccredit;
    }

    public double getCperiod() {
        return cperiod;
    }

    public void setCperiod(double cperiod) {
        this.cperiod = cperiod;
    }

    public Integer getCstate() {
        return cstate;
    }

    public void setCstate(Integer cstate) {
        this.cstate = cstate;
    }

    public Integer getCselcount() {
        return cselcount;
    }

    public void setCselcount(Integer cselcount) {
        this.cselcount = cselcount;
    }

    public Integer getCmaxcount() {
        return cmaxcount;
    }

    public void setCmaxcount(Integer cmaxcount) {
        this.cmaxcount = cmaxcount;
    }

    public String getStudytype() {
        return studytype;
    }

    public void setStudytype(String studytype) {
        this.studytype = studytype;
    }

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
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

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public Integer getSchid() {
        return schid;
    }

    public void setSchid(Integer schid) {
        this.schid = schid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getTchid() {
        return tchid;
    }

    public void setTchid(String tchid) {
        this.tchid = tchid;
    }

    public String getTgender() {
        return tgender;
    }

    public void setTgender(String tgender) {
        this.tgender = tgender;
    }

    public Date getTbirthday() {
        return tbirthday;
    }

    public void setTbirthday(Date tbirthday) {
        this.tbirthday = tbirthday;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTnation() {
        return tnation;
    }

    public void setTnation(String tnation) {
        this.tnation = tnation;
    }

    public String getTcardid() {
        return tcardid;
    }

    public void setTcardid(String tcardid) {
        this.tcardid = tcardid;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTaddress() {
        return taddress;
    }

    public void setTaddress(String taddress) {
        this.taddress = taddress;
    }

    public Date getEntertime() {
        return entertime;
    }

    public void setEntertime(Date entertime) {
        this.entertime = entertime;
    }

    public Date getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(Date leavetime) {
        this.leavetime = leavetime;
    }

    public Integer getTchstate() {
        return tchstate;
    }

    public void setTchstate(Integer tchstate) {
        this.tchstate = tchstate;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getCcount() {
        return ccount;
    }

    public void setCcount(Integer ccount) {
        this.ccount = ccount;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }

    public String getTimeinterval() {
        return timeinterval;
    }

    public void setTimeinterval(String timeinterval) {
        this.timeinterval = timeinterval;
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

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getTcsid() { return tcsid; }

    public void setTcsid(Integer tcsid) { this.tcsid = tcsid; }
}

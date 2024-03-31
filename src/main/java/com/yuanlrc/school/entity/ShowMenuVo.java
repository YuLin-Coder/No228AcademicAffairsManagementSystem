package com.yuanlrc.school.entity;

import java.util.ArrayList;
import java.util.List;

public class ShowMenuVo {

    private String id;

    private String pid;

    private String title;

    private String icon;

    private String href;

    private Boolean spread = Boolean.FALSE;

    private List<ShowMenuVo> children =  new ArrayList();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ShowMenuVo> getChildren() {
        return children;
    }

    public void setChildren(List<ShowMenuVo> children) {
        this.children = children;
    }
}

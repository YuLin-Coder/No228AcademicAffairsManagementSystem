package com.yuanlrc.school.common.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public abstract class TreeEntity<T extends Model> extends DataEntity<T> {

    private static final long serialVersionUID = 1L;

    /**
     * varchar(36) NULL父id
     */
    @TableField(value = "parent_id")
    protected String parentId;

    /**
     * 节点层次（第一层，第二层，第三层....）
     */
    protected Integer level;

    /**
     * varchar(2000) NULL路径
     */
    @TableField(value = "parent_ids")
    protected String parentIds;

    /**
     * int(11) NULL排序
     */
    protected Integer sort;

    @TableField(exist = false)
    protected List<T> children;

    @TableField(exist = false)
    protected T parentTree;

    public TreeEntity() {
        super();
        this.sort = 30;
    }

    public TreeEntity(String id) {
        super(id);
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Length( max = 1000, message = "路径长度必须介于 1 和 1000 之间")
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public T getParentTree() {
        return parentTree;
    }

    public void setParentTree(T parentTree) {
        this.parentTree = parentTree;
    }

}

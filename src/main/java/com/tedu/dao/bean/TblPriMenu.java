package com.tedu.dao.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author qiuwanfeng
 * @since 2020-05-25
 */
@TableName("tbl_pri_menu")
public class TblPriMenu extends Model<TblPriMenu> {

    private static final long serialVersionUID = 1L;

    @TableId
    @TableField("menu_id")
    private String menuId;
    @TableField("parent_menu_id")
    private String parentMenuId;
    @TableField("menu_name")
    private String menuName;
    @TableField("menu_desc")
    private String menuDesc;
    @TableField("created_time")
    private Date createdTime;


    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(String parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "TblPriMenu{" +
        "menuId=" + menuId +
        ", parentMenuId=" + parentMenuId +
        ", menuName=" + menuName +
        ", menuDesc=" + menuDesc +
        ", createdTime=" + createdTime +
        "}";
    }
}

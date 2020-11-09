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
@TableName("tbl_pri_role")
public class TblPriRole extends Model<TblPriRole> {

    private static final long serialVersionUID = 1L;

    @TableId
    @TableField("role_id")
    private String roleId;
    @TableField("role_name")
    private String roleName;
    @TableField("role_desc")
    private String roleDesc;
    @TableField("created_time")
    private Date createdTime;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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
        return "TblPriRole{" +
        "roleId=" + roleId +
        ", roleName=" + roleName +
        ", roleDesc=" + roleDesc +
        ", createdTime=" + createdTime +
        "}";
    }
}

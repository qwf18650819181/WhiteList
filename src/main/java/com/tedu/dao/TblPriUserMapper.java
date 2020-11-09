package com.tedu.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tedu.dao.bean.TblPriUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qiuwanfeng
 * @since 2020-05-25
 */
public interface TblPriUserMapper extends BaseMapper<TblPriUser> {

    @Select("select * from tbl_pri_user")
    public List<TblPriUser> getALl();
}

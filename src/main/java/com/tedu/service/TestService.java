package com.tedu.service;

import com.tedu.dao.TblPriUserMapper;
import com.tedu.dao.bean.TblPriUser;
import com.tedu.dao.common.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@TargetDataSource(name = TargetDataSource.DB1)
@Service("testService")
public class TestService {

    @Autowired
    private TblPriUserMapper tblPriUserDao;

    public TblPriUser getOneUser(){
        TblPriUser user = tblPriUserDao.selectOne(new TblPriUser());
        return user;
    }
    @TargetDataSource(name = TargetDataSource.DB2)
    public List<TblPriUser> getALlUser(){
        List<TblPriUser> users = tblPriUserDao.getALl();
        return users;
    }

    public void doSome(){
        System.out.println("good");
    }

}

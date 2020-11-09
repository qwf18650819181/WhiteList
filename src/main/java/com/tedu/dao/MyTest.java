package com.tedu.dao;

import com.tedu.dao.bean.TblPriUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tedu.service.TestService;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml","/spring-mvc.xml"})
public class MyTest {

    @Autowired
    private TestService testService;

    @Test
    public void main(){

        TblPriUser tblPriUser = testService.getOneUser();
        List<TblPriUser> users = testService.getALlUser();
        System.out.println("victory");

    }
}

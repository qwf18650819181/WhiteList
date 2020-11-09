package com.tedu.controller;

import com.tedu.service.TestService;
import com.tedu.util.ApplicationContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ApplicationContextFactory applicationContextFactory;

    @RequestMapping("/")
    public String getIndex(){
        TestService testService = applicationContextFactory.getBean("testService");
        testService.doSome();
        return "index";
    }
}

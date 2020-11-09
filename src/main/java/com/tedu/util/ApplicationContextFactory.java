package com.tedu.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ApplicationContextFactory implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public ApplicationContextFactory() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextFactory.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext(){
        checkApplicationContext();
        return applicationContext;
    }

    public void cleanApplicationContext(){
        applicationContext = null;
    }

    public void checkApplicationContext(){
        if (applicationContext == null) throw new IllegalStateException("applicationContextδע��,�붨��");
    }

    public <T>T getBean (String beanName){
        checkApplicationContext();
        return (T)applicationContext.getBean(beanName);
    }

    public <T>T getBean (Class<T> className){
        checkApplicationContext();
        return (T)applicationContext.getBeansOfType(className);
    }


}

package com.tedu.drools;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tedu.util.ApplicationContextFactory;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*: applicationContext.xml")
public class DroolsTest {
    private static KieContainer container = null;
    private KieSession statefulKieSession = null;



    @Test
    public void test(){
        ApplicationContext ac = new ApplicationContextFactory().getApplicationContext();


        KieServices kieServices = KieServices.Factory.get();
        container = kieServices.getKieClasspathContainer();
        statefulKieSession = container.newKieSession("myAgeSession");
        User user = new User(18);
        statefulKieSession.insert(user);
        statefulKieSession.fireAllRules();
        statefulKieSession.dispose();

    }



}

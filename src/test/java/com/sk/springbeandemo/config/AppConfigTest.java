package com.sk.springbeandemo.config;

import com.sk.springbeandemo.beans.ComplexBean;
import com.sk.springbeandemo.beans.SimpleBean;
import com.sk.springbeandemo.beans.SimpleBeanImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class AppConfigTest {

    private final Logger logger = LoggerFactory.getLogger(AppConfigTest.class);

    @Test
    public void testAppConfig(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            logger.info("Spring Bean : " + beanDefinitionName);
        }

    }

    @Test
    public void testSimpleBeanIsSingleton(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleBean bean1 = applicationContext.getBean(SimpleBean.class);
        logger.info("Bean1: "+bean1);
        SimpleBean bean2 = applicationContext.getBean(SimpleBean.class);
        assertEquals(bean1,bean2);
    }

    @Test
    public void testBeanNameSimpleIsInstanceOfSimpleBean(){
        ApplicationContext configurableApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SimpleBean bean = configurableApplicationContext.getBean("simpleBeanImpl",SimpleBean.class);
        assertNotNull(bean);
        for (String beanDefinitionName : configurableApplicationContext.getBeanDefinitionNames()) {
            logger.info("Bean name : "+beanDefinitionName +" of type -" +configurableApplicationContext.getBean(beanDefinitionName).getClass().getSimpleName());
        }

        assertTrue(bean instanceof SimpleBeanImpl);
    }

    @Test
    public void testTimeoutFromComplexBeanHasValue10(){
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ComplexBean cb = ctx.getBean(ComplexBean.class);
        assertNotNull(cb.retrieveSimpleBean());
        assertEquals("20", cb.retrieveTimeout());
        ctx.close();
    }
}

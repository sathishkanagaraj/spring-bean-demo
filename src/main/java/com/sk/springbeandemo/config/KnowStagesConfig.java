package com.sk.springbeandemo.config;

import com.sk.springbeandemo.beans.AnotherComplexBean;
import com.sk.springbeandemo.beans.AnotherSimpleBean;
import com.sk.springbeandemo.beans.SmallBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {KnowStagesConfig.class, AnotherComplexBean.class, AnotherSimpleBean.class, SmallBean.class})
public class KnowStagesConfig {
 /*private static final Logger LOGGER = LoggerFactory.getLogger(KnowStagesConfig.class);
   @Bean(initMethod = "beanInitMethod", destroyMethod = "killIt")
    public AnotherComplexBean anotherComplexBean(){
        LOGGER.info("Check when this is called and see it changes the order of the dependent bean instantiation");
        return new AnotherComplexBean();
    }*/
}

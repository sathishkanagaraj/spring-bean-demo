package com.sk.springbeandemo.config;

import com.sk.springbeandemo.beans.ChildBean;
import com.sk.springbeandemo.beans.ParentBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {InheritConfig.class, ParentBean.class, ChildBean.class})
public class InheritConfig {
}

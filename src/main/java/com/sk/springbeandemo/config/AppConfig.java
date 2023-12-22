package com.sk.springbeandemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = {"com.sk.springbeandemo.config",
        "com.sk.springbeandemo.beans",
"com.sk.springbeandemo.scope"})
@Configuration
@PropertySource("classpath:custom.properties")
public class AppConfig {





}

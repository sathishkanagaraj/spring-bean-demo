package com.sk.springbeandemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Bean
    Properties dbProps(){
        Properties properties = new Properties();
        properties.setProperty("driverClassName", "org.h2.Driver");
        properties.setProperty("url", "jdbc:h2:~/sample");
        properties.setProperty("username", "admin");
        properties.setProperty("password", "");
        return properties;
    }

    @Bean
    String dataSourceString(
            @Value("#{dbProps.driverClassName}") String driverClassName,
            @Value("#{dbProps.url}") String url
    ){
        return driverClassName + url;
    }
}

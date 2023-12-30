package com.sk.springbeandemo.config;

import com.sk.springbeandemo.beans.SimpleBean;
import com.sk.springbeandemo.beans.SimpleBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
@ComponentScan(basePackages = {"com.sk.springbeandemo.*"})
public class CollectionConfig {

    @Bean
    SimpleBean simpleBean(){
        return new SimpleBeanImpl();
    }

    @Bean
    List<SimpleBean> simpleBeanList(){
        return List.of(simpleBean());
    }

    @Bean
    Set<SimpleBean> simpleBeanSet(){
        return Set.of(simpleBean());
    }

    @Bean
    Map<String, SimpleBean> simpleBeanMap(){
        return Map.of("simpleBean",simpleBean());
    }
}

package com.sk.springbeandemo.config;

import com.sk.springbeandemo.beans.MultiTypeBean;
import com.sk.springbeandemo.converter.CustomDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

import java.util.Set;

@Configuration
@ComponentScan(basePackageClasses = {DateConfig.class, MultiTypeBean.class, CustomDateConverter.class})
public class DateConfig {

    @Autowired
    CustomDateConverter customDateConverter;

    @Bean
    ConversionService conversionService(ConversionServiceFactoryBean factoryBean){
        return factoryBean.getObject();
    }

    @Bean
    ConversionServiceFactoryBean conversionServiceFactoryBean(){
        ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
        conversionServiceFactoryBean.setConverters(Set.of(customDateConverter));
        return conversionServiceFactoryBean;
    }
}

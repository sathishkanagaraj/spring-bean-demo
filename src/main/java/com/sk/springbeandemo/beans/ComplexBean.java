package com.sk.springbeandemo.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public interface ComplexBean extends InitializingBean, DisposableBean {

    String retrieveTimeout();
    int retrieveWakeUp();

    SimpleBean retrieveSimpleBean();
}

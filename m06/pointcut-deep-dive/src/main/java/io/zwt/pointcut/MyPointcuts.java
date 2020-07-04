package io.zwt.pointcut;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    // 将 Pointcut 表达式放到一个被注解的方法中
    @Pointcut("bean(*Service)")
    public void beanNamePointcut() {
    }
}

package io.zwt.loadtimeweaving;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DemoAspect {

    @Before("execution(void advisedMethod())")
    public void logException() {
        System.out.println("Aspect called!");
    }
}

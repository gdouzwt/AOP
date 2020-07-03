package io.zwt.aspects;


import io.zwt.demo.DemoClass;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManuallyAddingAdvice {

    @Test
    public void addedAdviceIsCalled() {
        DemoAspect demoAspect = new DemoAspect();
        DemoClass originalObject = new DemoClass();
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(
            originalObject);
        proxyFactory.addAspect(demoAspect);
        DemoClass proxy = proxyFactory.getProxy();
        assertFalse(demoAspect.isCalled());
        proxy.advicedMethod();
        assertTrue(demoAspect.isCalled());
    }
}

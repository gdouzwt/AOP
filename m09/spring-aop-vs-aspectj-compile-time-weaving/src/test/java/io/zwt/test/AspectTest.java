package io.zwt.test;

import io.zwt.compiletimeweaving.DemoAspect;
import io.zwt.demo.DemoClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AspectTest {

    @Test
    public void adviceIsCalled() {
        assertFalse(DemoAspect.isCalled());
        DemoClass demoClass = new DemoClass();
        demoClass.callsTheAdvisedMethod();
        assertTrue(DemoAspect.isCalled());
    }

}

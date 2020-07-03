package io.zwt.test;

import io.zwt.compiletimeweaving.DemoAspect;
import io.zwt.demo.DemoClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AspectTest {

    @Test
    public void adviceIsCalled() {
        assertFalse(DemoAspect.isCalled());
        DemoClass demoClass = new DemoClass();
        demoClass.advisedMethod();
        assertTrue(DemoAspect.isCalled());
    }
}

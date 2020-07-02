package io.zwt.test;

import static org.junit.Assert.*;
import org.junit.Test;

import io.zwt.compiletimeweaving.DemoAspect;
import io.zwt.demo.DemoClass;

public class AspectTest {

  @Test
  public void adviceIsCalled() {
    assertFalse(DemoAspect.isCalled());
    DemoClass demoClass = new DemoClass();
    demoClass.advicedMethod();
    assertTrue(DemoAspect.isCalled());
  }
}

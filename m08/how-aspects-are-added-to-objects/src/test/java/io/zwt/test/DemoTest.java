package io.zwt.test;

import io.zwt.aspects.DemoAspect;
import io.zwt.config.SystemConfiguration;
import io.zwt.demo.DemoClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class DemoTest {

    @Autowired
    DemoAspect demoAspect;

    @Autowired
    DemoClass demoClass;

    @BeforeEach
    public void setUp() {
        demoAspect.resetCalled();
    }

    @Test
    public void directCallToAdvisedMethodIsTraced() {
        assertFalse(demoAspect.isCalled());
        demoClass.advisedMethod();
        assertTrue(demoAspect.isCalled());
    }

    @Test
    public void indirectCallToAdvisedMethodIsNotTraced() {
        assertFalse(demoAspect.isCalled());
        demoClass.callsTheAdvisedMethod();
        assertFalse(demoAspect.isCalled());
    }

}

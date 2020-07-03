package io.zwt.simpleaspect;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ContextConfiguration("classpath:simpleaspect.xml")
public class SimpleAspectXMLTest {

    @Autowired
    TracingAspect tracingAspect;

    @Autowired
    SimpleService simpleService;

    @Test
    public void aspectIsCalled() {
        assertFalse(tracingAspect.isEnteringCalled());
        simpleService.doSomethingElse(42);
        assertTrue(tracingAspect.isEnteringCalled());
    }

}

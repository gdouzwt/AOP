package io.zwt.test;

import io.zwt.aspect.TracingAspect;
import io.zwt.config.Config;
import io.zwt.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
// 包结构要对应，不然不知道 fallback 到哪里，找不到 @SpringBootConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class SimpleAspectJavaConfigTest {

    @Autowired
    TracingAspect tracingAspect;

    @Autowired
    SimpleService simpleService;

    @Test
    public void aspectIsCalled() {
        assertFalse(tracingAspect.isEnteringCalled());
        simpleService.doSomething();
        assertTrue(tracingAspect.isEnteringCalled());
    }

}

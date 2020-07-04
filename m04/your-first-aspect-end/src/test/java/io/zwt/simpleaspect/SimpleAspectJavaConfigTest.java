package io.zwt.simpleaspect;

import io.zwt.SimpleAspectConfiguration;
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
@ContextConfiguration(classes = SimpleAspectConfiguration.class)
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

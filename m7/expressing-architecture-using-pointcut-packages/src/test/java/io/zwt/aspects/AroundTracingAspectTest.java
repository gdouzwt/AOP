package io.zwt.aspects;

import io.zwt.repository.MyRepository;
import io.zwt.service.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:system-configuration.xml")
public class AroundTracingAspectTest {

    @Autowired
    TracingAspect tracingAspect;

    @Autowired
    MyService myService;

    @Autowired
    MyRepository myRepository;

    @BeforeEach
    public void setUp() {
        tracingAspect.resetCalled();
    }

    @Test
    public void tracingIsCalledForRepositories() {
        assertFalse(tracingAspect.isCalled());
        myRepository.doIt();
        assertTrue(tracingAspect.isCalled());
    }

    @Test
    public void tracingIsCalledForServices() {
        assertFalse(tracingAspect.isCalled());
        myService.doIt();
        assertTrue(tracingAspect.isCalled());
    }

}

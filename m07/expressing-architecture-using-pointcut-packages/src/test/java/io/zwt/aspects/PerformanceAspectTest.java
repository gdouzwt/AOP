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
public class PerformanceAspectTest {

    @Autowired
    PerformanceAspect performanceAspect;

    @Autowired
    MyService myService;

    @Autowired
    MyRepository myRepository;

    @BeforeEach
    public void setUp() {
        performanceAspect.resetCalled();
    }

    @Test
    public void performanceIsCalledForRepositories() {
        assertFalse(performanceAspect.isCalled());
        myRepository.doIt();
        assertTrue(performanceAspect.isCalled());
    }

    @Test
    public void performanceIsNotCalledForServices() {
        assertFalse(performanceAspect.isCalled());
        myService.doIt();
        assertFalse(performanceAspect.isCalled());
    }

}

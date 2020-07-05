package io.zwt.test;

import io.zwt.aspects.PerformanceAspect;
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


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:system-configuration.xml")
public class PerformanceAspectTest {

    @Autowired
    PerformanceAspect performanceAspect;

    /*因为在 xml 配置里面加了 use-default-filters="false"，所以 Idea 不清楚，加红色波浪线，实际上运行没有问题*/
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MyService myService;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
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

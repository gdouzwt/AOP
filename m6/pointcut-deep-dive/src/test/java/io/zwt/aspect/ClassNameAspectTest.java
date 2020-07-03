package io.zwt.aspect;

import io.zwt.configuration.SystemConfiguration;
import io.zwt.repository.SimpleRepository;
import io.zwt.service.SimpleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class ClassNameAspectTest {

    @Autowired
    ClassNameAspect aroundTracingAspect;

    @Autowired
    SimpleService simpleService;

    @Autowired
    SimpleRepository simpleRepository;

    @BeforeEach
    public void setUp() {
        aroundTracingAspect.resetCalled();
    }

    @Test
    public void tracingOnServiceIsCalled() {
        Assertions.assertEquals(aroundTracingAspect.getCalled(), 0);
        simpleService.doSomething();
        Assertions.assertEquals(aroundTracingAspect.getCalled(), 1);
    }

    @Test
    public void tracingOnRepositoryIsNotCalled() {
        Assertions.assertEquals(aroundTracingAspect.getCalled(), 0);
        simpleRepository.doSomething();
        Assertions.assertEquals(aroundTracingAspect.getCalled(), 0);
    }

}

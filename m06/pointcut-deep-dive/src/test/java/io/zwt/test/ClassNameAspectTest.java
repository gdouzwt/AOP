package io.zwt.test;

import io.zwt.aspect.ClassNameAspect;
import io.zwt.config.Config;
import io.zwt.repository.SimpleRepository;
import io.zwt.service.SimpleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
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
        assertEquals(aroundTracingAspect.getCalled(), 0);
        simpleService.doSomething();
        assertEquals(aroundTracingAspect.getCalled(), 1);
    }

    @Test
    public void tracingOnRepositoryIsNotCalled() {
        assertEquals(aroundTracingAspect.getCalled(), 0);
        simpleRepository.doSomething();
        assertEquals(aroundTracingAspect.getCalled(), 0);
    }

}

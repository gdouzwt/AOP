package io.zwt.aspect;

import io.zwt.configuration.SystemConfiguration;
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
@ContextConfiguration(classes = SystemConfiguration.class)
public class BeanNameAspectTest {

    @Autowired
    BeanNameAspect beanNameAspect;

    @Autowired
    SimpleService simpleService;

    @Autowired
    SimpleRepository simpleRepository;

    @BeforeEach
    public void setUp() {
        beanNameAspect.resetCalled();
    }

    @Test
    public void tracingOnServiceIsCalled() {
        assertEquals(beanNameAspect.getCalled(), 0);
        simpleService.doSomething();
        assertEquals(beanNameAspect.getCalled(), 1);
    }

    @Test
    public void tracingOnRepositoryIsNotCalled() {
        assertEquals(beanNameAspect.getCalled(), 0);
        simpleRepository.doSomething();
        assertEquals(beanNameAspect.getCalled(), 0);
    }

}

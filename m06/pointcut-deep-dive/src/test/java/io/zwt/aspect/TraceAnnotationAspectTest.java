package io.zwt.aspect;

import io.zwt.configuration.SystemConfiguration;
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
public class TraceAnnotationAspectTest {

    @Autowired
    TraceAnnotationAspect traceAnnotationAspect;

    @Autowired
    SimpleService simpleService;

    @BeforeEach
    public void setUp() {
        traceAnnotationAspect.resetCalled();
    }

    @Test
    public void tracingOnNotAnnotatedMethodIsNotCalled() {
        Assertions.assertEquals(traceAnnotationAspect.getCalled(), 0);
        simpleService.doSomething();
        Assertions.assertEquals(traceAnnotationAspect.getCalled(), 0);
    }

    @Test
    public void tracingOnAnnotatedMethodIsCalled() {
        Assertions.assertEquals(traceAnnotationAspect.getCalled(), 0);
        simpleService.annotated();
        Assertions.assertEquals(traceAnnotationAspect.getCalled(), 1);
    }

}

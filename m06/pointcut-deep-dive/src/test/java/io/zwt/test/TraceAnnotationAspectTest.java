package io.zwt.test;

import io.zwt.aspect.TraceAnnotationAspect;
import io.zwt.config.Config;
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
        assertEquals(traceAnnotationAspect.getCalled(), 0);
        simpleService.doSomething();
        assertEquals(traceAnnotationAspect.getCalled(), 0);
    }

    @Test
    public void tracingOnAnnotatedMethodIsCalled() {
        assertEquals(traceAnnotationAspect.getCalled(), 0);
        simpleService.annotated();
        assertEquals(traceAnnotationAspect.getCalled(), 1);
    }

}

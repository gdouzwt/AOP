package io.zwt.aspects;

import io.zwt.repository.MyRepository;
import io.zwt.service.MyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:system-configuration.xml")
public class ExceptionLoggingAspectTest {

    @Autowired
    ExceptionLoggingAspect exceptionLoggingAspect;

    @Autowired
    MyService myService;

    @Autowired
    MyRepository myRepository;

    @BeforeEach
    public void setUp() {
        exceptionLoggingAspect.resetCalled();
    }

    @Test
    public void exceptionLoggingIsNotCalledIfNoExceptionIsThrown() {
        assertFalse(exceptionLoggingAspect.isCalled());
        myRepository.doIt();
        assertFalse(exceptionLoggingAspect.isCalled());
    }

    @Test
    public void exceptionLoggingIsCalledIfExceptionIsThrown() {
        assertFalse(exceptionLoggingAspect.isCalled());
        assertThrows(RuntimeException.class, () -> myRepository.throwsException());
        assertTrue(exceptionLoggingAspect.isCalled());
    }

}

package io.zwt.test;

import io.zwt.advice.AfterThrowingAdvice;
import io.zwt.advice.SimpleService;
import io.zwt.config.Config;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class AfterThrowingAdviceTest {

    @Autowired
    AfterThrowingAdvice afterThrowingAdvice;

    @Autowired
    SimpleService simpleService;

    @BeforeEach
    public void rest() {
        afterThrowingAdvice.reset();
    }

    @Test
    public void afterThrowingIsNotCalledIfMethodReturnSuccessfully() {
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
        simpleService.doSomething();
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
    }

    @Test
    public void afterThrowingIsCalledIfMethodThrowsRuntimeException() {
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
        assertThrows(RuntimeException.class, () -> simpleService.throwsRuntimeException());
        assertTrue(afterThrowingAdvice.isAfterThrowingCalled());
    }

    @Test
    public void afterThrowingIsNotCalledIfMethodThrowsException() {
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
        assertThrows(Exception.class, () -> simpleService.throwsException());
        assertFalse(afterThrowingAdvice.isAfterThrowingCalled());
    }

}

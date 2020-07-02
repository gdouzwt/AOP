package advicedeepdive;


import configuration.AdviceDeepDiveConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AdviceDeepDiveConfiguration.class)
public class AfterAdviceTest {

    @Autowired
    AfterAdvice afterAdvice;

    @Autowired
    SimpleService simpleService;

    @BeforeEach
    public void reset() {
        afterAdvice.reset();
    }

    @Test
    public void afterAspectIsCalledIfMethodReturnsSuccessfully() {
        assertFalse(afterAdvice.isAfterCalled());
        simpleService.doSomething();
        assertTrue(afterAdvice.isAfterCalled());
    }

    @Test
    public void afterAspectIsCalledIfMethodThrowsException() {

        assertFalse(afterAdvice.isAfterCalled());
        assertThrows(RuntimeException.class, () -> {
            simpleService.throwsRuntimeException();
        });
        assertTrue(afterAdvice.isAfterCalled());
    }

}

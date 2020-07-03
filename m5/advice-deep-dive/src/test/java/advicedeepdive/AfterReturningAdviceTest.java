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
public class AfterReturningAdviceTest {

    @Autowired
    AfterReturningAdvice afterReturningAdvice;

    @Autowired
    SimpleService simpleService;

    @BeforeEach
    public void reset() {
        afterReturningAdvice.reset();
    }

    @Test
    public void afterReturningIsNotCalledIfReturnTypeDoesntMatch() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        simpleService.returnsInt();
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
    }

    @Test
    public void afterReturningIsNotCalledIfExceptionIsThrown() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        assertThrows(RuntimeException.class, () -> simpleService.returnsStringAndThrowsRuntimeException());
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
    }

    @Test
    public void afterReturningIsCalledIfReturnTypeMatches() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        simpleService.returnsString();
        assertTrue(afterReturningAdvice.isAfterReturningCalled());
    }

}

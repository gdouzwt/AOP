package advicedeepdive;

import configuration.AdviceDeepDiveConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AdviceDeepDiveConfiguration.class)
public class AroundAdviceTest {

    @Autowired
    AroundAdvice aroundAspect;

    @Autowired
    SimpleService simpleService;

    @BeforeEach
    public void rest() {
        aroundAspect.reset();
    }

    @Test
    public void aroundAdviceIsCalledForSimpleMethod() {
        assertFalse(aroundAspect.isCalled());
        simpleService.doSomething();
        assertTrue(aroundAspect.isCalled());
    }

    @Test
    public void aroundAdviceIsCalledIfExceptionIsThrown() {
        assertFalse(aroundAspect.isCalled());
        assertThrows(RuntimeException.class, () -> simpleService.throwsRuntimeException());
        assertTrue(aroundAspect.isCalled());
    }

    @Test
    public void aroundAdviceIsCalledIfValueIsReturned() {
        assertFalse(aroundAspect.isCalled());
        Assertions.assertEquals(simpleService.returnsString(), "42");
        assertTrue(aroundAspect.isCalled());
    }

}

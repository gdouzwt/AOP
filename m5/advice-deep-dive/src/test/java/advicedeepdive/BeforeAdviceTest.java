package advicedeepdive;


import configuration.AdviceDeepDiveConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AdviceDeepDiveConfiguration.class)
public class BeforeAdviceTest {

    @Autowired
    BeforeAdvice beforeAspect;

    @Autowired
    SimpleService simpleService;

    @BeforeEach
    public void reset() {
        beforeAspect.reset();
    }

    @Test
    public void beforeIsCalledIfCorrectMethodIsCalled() {
        assertFalse(beforeAspect.isBeforeCalled());
        simpleService.doSomething();
        assertTrue(beforeAspect.isBeforeCalled());
    }

    @Test
    public void beforeIsNotCalledIfDifferentMethodIsCalled() {
        assertFalse(beforeAspect.isBeforeCalled());
        simpleService.returnsString();
        assertFalse(beforeAspect.isBeforeCalled());
    }

}

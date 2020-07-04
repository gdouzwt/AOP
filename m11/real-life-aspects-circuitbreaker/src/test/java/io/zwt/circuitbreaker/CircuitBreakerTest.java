package io.zwt.circuitbreaker;

import io.zwt.config.SystemConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.fail;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class CircuitBreakerTest {

    @Autowired
    private CircuitBreakerServiceImpl circuitBreakerServiceImpl;

    @Autowired
    private CircuitBreakerServiceImpl2 circuitBreakerServiceImpl2;

    public void methodShouldExecuteWithoutExceptionAfter10Tries(
        CircuitBreakerService service) {
        for (int i = 0; i < 9; i++) {
            try {
                service.erroneousMethod();
                fail("Expected failure in iteration " + i + " !");
            } catch (RuntimeException ignored) {
            }
        }
        service.erroneousMethod();
    }

    @Test
    public void restErroneousService2() {
        methodShouldExecuteWithoutExceptionAfter10Tries(circuitBreakerServiceImpl2);
    }

    @Test
    public void restErroneousService() {
        methodShouldExecuteWithoutExceptionAfter10Tries(circuitBreakerServiceImpl);
    }

}

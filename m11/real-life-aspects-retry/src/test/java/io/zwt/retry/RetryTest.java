package io.zwt.retry;

import io.zwt.config.SystemConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class RetryTest {

    @Autowired
    ErroneousService erroneousService;

    @Test
    public void withSpringErroneousServiceIsRetriedNoExceptionThrown() {
        erroneousService.throwException();
    }

    @Test
    public void withoutSpringErroneousServiceThrowsException() {
        ErroneousService erroneousService = new ErroneousService();
        assertThrows(RuntimeException.class,
            erroneousService::throwException);
    }
}

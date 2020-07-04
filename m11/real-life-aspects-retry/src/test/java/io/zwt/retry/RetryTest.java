package io.zwt.retry;

import configuration.SystemConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
        Assertions.assertThrows(RuntimeException.class,
            erroneousService::throwException);
    }
}

package io.zwt.aspects;

import io.zwt.service.PlainService;
import io.zwt.transaction.StubPlatformTransactionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:system-configuration.xml")
public class TransactionTest {

    @Autowired
    PlainService plainService;

    @Autowired
    StubPlatformTransactionManager stubPlatformTransactionManager;

    @Test
    public void callService() {
        Assertions.assertEquals(stubPlatformTransactionManager.getTotal(), 0);
        Assertions.assertEquals(stubPlatformTransactionManager.getTotal(), 0);
        plainService.doSomething();
        Assertions.assertEquals(stubPlatformTransactionManager.getTotal(), 1);
        Assertions.assertEquals(stubPlatformTransactionManager.getCommit(), 1);
    }

}

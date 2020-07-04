package io.zwt.aspects;

import io.zwt.service.PlainService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:system-configuration.xml")
public class TracingTest {

    @Autowired
    PlainService plainService;

    @Test
    public void callService() {
        plainService.doSomething();
    }

}

package io.zwt.datacapture;

import configuration.SystemConfiguration;
import io.zwt.service.PlainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class DataCaptureTest {

    @Autowired
    private PlainService plainServer;

    @Test
    public void test() {
        Assertions.assertThrows(RuntimeException.class,
            () -> plainServer.doIt(42));
    }
}

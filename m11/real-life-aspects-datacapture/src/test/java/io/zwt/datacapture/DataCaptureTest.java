package io.zwt.datacapture;

import io.zwt.config.SystemConfiguration;
import io.zwt.service.PlainService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class DataCaptureTest {

    @Autowired
    private PlainService plainServer;

    @Test
    public void test() {
        assertThrows(RuntimeException.class,
            () -> plainServer.doIt(42));
    }
}

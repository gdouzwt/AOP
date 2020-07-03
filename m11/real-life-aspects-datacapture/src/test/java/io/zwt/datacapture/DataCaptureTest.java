package io.zwt.datacapture;

import configuration.SystemConfiguration;
import io.zwt.service.PlainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class DataCaptureTest {

    @Autowired
    private PlainService plainServer;

    @Test(expected = RuntimeException.class)
    public void test() {
        plainServer.doIt(42);
    }
}

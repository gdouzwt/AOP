package io.zwt;

import io.zwt.domain.DomainObject;
import io.zwt.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ConfigurationMethodTest {

    @Autowired
    private SimpleService simpleService;

    @Test
    public void dependencyInjectionShouldWork() {
        assertNotNull(simpleService);
    }

    @Test
    public void serviceShouldReturnDomainObject() {
        assertEquals(simpleService.service(), new DomainObject());
    }

}

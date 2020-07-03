package io.zwt;

import io.zwt.domain.DomainObject;
import io.zwt.service.SimplestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration("classpath:component-scanning.xml")
public class ConfigurationComponentScanningTest {

    @Autowired
    private SimplestService simpleService;

    @Test
    public void dependencyInjectionShouldWork() {
        assertNotNull(simpleService);
    }

    @Test
    public void serviceShouldReturnDomainObject() {
        Assertions.assertEquals(simpleService.service(), new DomainObject());
    }
}

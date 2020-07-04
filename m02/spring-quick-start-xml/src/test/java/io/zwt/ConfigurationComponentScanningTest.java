package io.zwt;

import io.zwt.domain.DomainObject;
import io.zwt.service.SimplestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
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
        assertEquals(simpleService.service(), new DomainObject());
    }
}

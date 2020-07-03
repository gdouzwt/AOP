package io.zwt;

import io.zwt.domain.DomainObject;
import io.zwt.service.SimplestService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:beans.xml")
public class ConfigurationBeansTest {

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

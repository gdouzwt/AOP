package io.zwt;

import io.zwt.config.Config;
import io.zwt.domain.DomainObject;
import io.zwt.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class ComponentScanningTest {

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

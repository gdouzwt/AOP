package io.zwt.filter;

import io.zwt.config.SystemConfiguration;
import io.zwt.aspect.AccountFilterAspect;
import io.zwt.domain.Account;
import io.zwt.domain.Customer;
import io.zwt.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SystemConfiguration.class)
public class FilterTest {

    @Autowired
    private AccountFilterAspect accountFilterAspect;

    @Autowired
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        accountFilterAspect.clearCurrentCustomer();
    }

    @Test
    public void springBeanFiltersEverythingIfNoCustomerSet() {
        assertNull(accountRepository.getAccount(42));
        assertNull(accountRepository.getAccount(1));
    }

    @Test
    public void springBeanFiltersOtherAccountIfCustomerSet() {
        accountFilterAspect.setCurrentCustomer(new Customer("Eberhard", "Wolff"));
        assertEquals(accountRepository.getAccount(42), new Account(
            "Eberhard", "Wolff", 42));
        assertNull(accountRepository.getAccount(1));
    }


    @Test
    public void plainObjectWontFilter() {
        AccountRepository plainAccountRepository = new AccountRepository();
        assertEquals(plainAccountRepository.getAccount(42), new Account(
            "Eberhard", "Wolff", 42));
        assertEquals(plainAccountRepository.getAccount(1), new Account(
            "Juergen", "Hoeller", 1));
    }

}

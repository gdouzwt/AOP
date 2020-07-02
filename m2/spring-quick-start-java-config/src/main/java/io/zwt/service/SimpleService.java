package io.zwt.service;

import io.zwt.domain.DomainObject;
import io.zwt.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleService {

    @Autowired
    SimpleRepository repository;

    public DomainObject service() {
        return repository.findDomainObject();
    }
}

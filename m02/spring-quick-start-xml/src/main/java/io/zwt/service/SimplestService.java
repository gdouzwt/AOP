package io.zwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.zwt.domain.DomainObject;
import io.zwt.repository.SimpleRepository;

@Service
public class SimplestService {

    @Autowired
    SimpleRepository repository;

    public DomainObject service() {
        return repository.findDomainObject();
    }
}

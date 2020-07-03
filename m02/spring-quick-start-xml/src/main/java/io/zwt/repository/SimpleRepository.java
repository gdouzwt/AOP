package io.zwt.repository;

import org.springframework.stereotype.Repository;

import io.zwt.domain.DomainObject;

@Repository
public class SimpleRepository {

    public DomainObject findDomainObject() {
        return new DomainObject();
    }

}

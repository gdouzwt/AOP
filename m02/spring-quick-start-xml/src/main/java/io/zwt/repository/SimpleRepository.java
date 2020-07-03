package io.zwt.repository;

import io.zwt.domain.DomainObject;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleRepository {

    public DomainObject findDomainObject() {
        return new DomainObject();
    }

}

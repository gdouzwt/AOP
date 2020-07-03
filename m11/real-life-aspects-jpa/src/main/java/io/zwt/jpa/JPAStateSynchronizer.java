package io.zwt.jpa;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Aspect
public class JPAStateSynchronizer {

    @PersistenceContext
    private EntityManager entityManager;

    @Before("execution(* org.springframework.jdbc.core.JdbcTemplate.*(..) )")
    public void flush() {
        if (entityManager != null) {
            entityManager.flush();
        }
    }

}

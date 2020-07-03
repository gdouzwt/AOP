package io.zwt;

import io.zwt.domain.DomainObject;
import io.zwt.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    SimpleRepository repository;

    @Bean
    ApplicationRunner runner() {
        return (args) -> {
            DomainObject domainObject = repository.findDomainObject();
            System.out.println(domainObject);
        };
    }
}

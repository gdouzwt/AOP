package io.zwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /*@Autowired
    SimpleRepository repository;

    @Bean
    ApplicationRunner runner() {
        return (args) -> {
            DomainObject domainObject = repository.findDomainObject();
            System.out.println(domainObject);
        };
    }*/
}

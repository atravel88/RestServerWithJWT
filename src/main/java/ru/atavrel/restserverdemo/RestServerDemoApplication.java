package ru.atavrel.restserverdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("ru.atavrel.restserverdemo.dao")
@EntityScan("ru.atavrel.restserverdemo.model")
@SpringBootApplication
public class RestServerDemoApplication {
    public static void main(String[] args) { SpringApplication.run(RestServerDemoApplication.class, args);
    }
}

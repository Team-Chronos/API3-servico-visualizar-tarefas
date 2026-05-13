package com.api.visualizarTarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.api.visualizarTarefas"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
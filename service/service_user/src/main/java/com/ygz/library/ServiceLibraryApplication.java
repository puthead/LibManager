package com.ygz.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.lib.common")
@ComponentScan("com.ygz.*")
public class ServiceLibraryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceLibraryApplication.class,args);
    }
}

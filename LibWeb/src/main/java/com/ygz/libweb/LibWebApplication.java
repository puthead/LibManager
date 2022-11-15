package com.ygz.libweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LibWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibWebApplication.class, args);
    }

}

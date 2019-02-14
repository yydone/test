package com.yydone.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * @author renwoxing
 * @date 2019/02/11
 */
@ComponentScan("com.yydone.demo")
@EnableAutoConfiguration
@EnableNeo4jRepositories(basePackages = "com.yydone.demo.dal.mapper")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

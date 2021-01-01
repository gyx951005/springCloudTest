package com.cloud.gateway.gateway9527;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Gateway9527Application 
{
    public static void main(String[] args) throws Exception {
		SpringApplication.run(Gateway9527Application.class, args);
	}

}

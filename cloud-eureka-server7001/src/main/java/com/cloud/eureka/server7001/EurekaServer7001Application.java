package com.cloud.eureka.server7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001Application 
{
    public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServer7001Application.class, args);
	}

}

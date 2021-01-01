package com.colud.eureka.server7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7002Application 
{
    public static void main(String[] args) throws Exception {
		SpringApplication.run(EurekaServer7002Application.class, args);
	}

}

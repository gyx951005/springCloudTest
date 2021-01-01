package com.cloud.eureka.provider.payment8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderPayment8002application 
{
    public static void main(String[] args) throws Exception {
		SpringApplication.run(ProviderPayment8002application.class, args);
	}

}

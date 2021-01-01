package com.cloud.eureka.openfeign.order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OpenfeignOrder80Application 
{
    public static void main(String[] args) throws Exception {
		SpringApplication.run(OpenfeignOrder80Application.class, args);
	}

}

package com.cloud.eureka.consumer.order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.cloud.eureka.consumer.myrule.Myrule;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-payment-server", configuration = Myrule.class) //配置ribbon负载均衡算法
public class ConsumerOrder80Application 
{
    public static void main(String[] args) throws Exception {
		SpringApplication.run(ConsumerOrder80Application.class, args);
	}

}

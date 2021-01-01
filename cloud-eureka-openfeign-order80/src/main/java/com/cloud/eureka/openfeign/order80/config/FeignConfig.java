package com.cloud.eureka.openfeign.order80.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;


/**
 * feign 日志级别配置
 * @author Administrator
 *
 */
@Configuration
public class FeignConfig {

	@Bean
	public Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;
	}
}

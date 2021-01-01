package com.cloud.eureka.consumer.payment8001.config;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
public class ScheduledConfigration implements SchedulingConfigurer{

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(getExecutor());
	}
	
	@Bean(destroyMethod = "shutdown")
	public Executor getExecutor() {
		return Executors.newScheduledThreadPool(3);
	}

}

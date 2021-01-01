package com.cloud.eureka.consumer.payment8001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class DiscoveryController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/discovery")
	public Object getDiscovery() {
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			System.out.println(service);
		}
		
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
		for (ServiceInstance serviceInstance : instances) {
			System.out.println(serviceInstance.getHost() + serviceInstance.getPort() + serviceInstance.getUri());
		}
		return this.discoveryClient;
	}
}

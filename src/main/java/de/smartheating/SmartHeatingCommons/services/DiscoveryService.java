package de.smartheating.SmartHeatingCommons.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DiscoveryService {
	
	Logger logger = LoggerFactory.getLogger(DiscoveryService.class);

	@Autowired
	DiscoveryClient discoveryClient;

	public String getServiceUrl(String serviceId) throws NotFoundException {
		// Get ServiceInstance from Eureka
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);

		if (serviceInstances.isEmpty() || serviceInstances == null) {
			throw new NotFoundException("Service with id: '" + serviceId + "' is not registered with eureka!");
		}

		// Since we will only have one instance per service
		logger.info("Returning URL '" + serviceInstances.get(0).getUri().toString() + "' for service with id '" + serviceId + "'");
		return serviceInstances.get(0).getUri().toString();
	}
}

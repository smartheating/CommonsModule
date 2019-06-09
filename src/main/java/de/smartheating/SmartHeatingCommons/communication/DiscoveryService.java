package de.smartheating.SmartHeatingCommons.communication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class DiscoveryService {

	@Autowired
	DiscoveryClient discoveryClient;

	public String getServiceUrl(String serviceId) throws NotFoundException {
		// Get ServiceInstance from Eureka
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);

		if (serviceInstances.isEmpty() || serviceInstances == null) {
			throw new NotFoundException("Service with id: '" + serviceId + "' is not registered with eureka!");
		}

		// Since we will only have one instance per service
		return serviceInstances.get(0).getUri().toString();
	}
}

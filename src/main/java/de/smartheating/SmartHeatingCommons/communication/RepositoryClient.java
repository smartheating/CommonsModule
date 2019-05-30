package de.smartheating.SmartHeatingCommons.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import de.smartheating.SmartHeatingCommons.exceptions.ProfileNotSetException;
import de.smartheating.SmartHeatingCommons.persistedData.Device;
import de.smartheating.SmartHeatingCommons.persistedData.SensorEvent;

@Component
public class RepositoryClient {
	
	Logger logger = LoggerFactory.getLogger(RepositoryClient.class);
	
	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@Autowired
	RestTemplate rest;
	
	public Device addDevice(Device device) throws ProfileNotSetException, RestClientException {	
		return rest.postForObject(buildUrl("devices"), new HttpEntity<>(device), Device.class);
	}
	
	public SensorEvent addEvent(SensorEvent event) throws ProfileNotSetException, RestClientException {	
		return rest.postForObject(buildUrl("sensorevents"), new HttpEntity<>(event), SensorEvent.class);
	}
	
	private String buildUrl(String endpoint) throws ProfileNotSetException {
		if (activeProfile.equals("dev")) {
			return "http://localhost:9011/" + endpoint;
		} else if(activeProfile.equals("docker")) {
			return "http://repository:9011/" + endpoint;
		} else {
			throw new ProfileNotSetException("No or unknown Spring-Profile is activ!");
		}
	}
}

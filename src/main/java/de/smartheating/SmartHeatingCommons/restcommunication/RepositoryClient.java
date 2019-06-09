package de.smartheating.SmartHeatingCommons.restcommunication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import de.smartheating.SmartHeatingCommons.persistedData.Device;
import de.smartheating.SmartHeatingCommons.persistedData.Event;

@Component
public class RepositoryClient {
	
	Logger logger = LoggerFactory.getLogger(RepositoryClient.class);
	
	@Value("${spring.profiles.active}")
	private String activeProfile;
	
	@Autowired
	RestTemplate rest;
	
	public Device addDevice(String url, Device device) throws RestClientException {	
		return rest.postForObject(url + "/devices", new HttpEntity<>(device), Device.class);
	}
	
	public Event addEvent(String url, Event event) throws RestClientException {	
		return rest.postForObject(url + "/events", new HttpEntity<>(event), Event.class);
	}

}
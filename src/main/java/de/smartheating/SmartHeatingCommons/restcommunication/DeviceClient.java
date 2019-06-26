package de.smartheating.SmartHeatingCommons.restcommunication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import de.smartheating.SmartHeatingCommons.persistedData.Event;

@Component
public class DeviceClient {
	
Logger logger = LoggerFactory.getLogger(DeviceClient.class);
	
	@Autowired
	RestTemplate rest;

	public void updateDeviceValue(String url, Event event) throws RestClientException {
		logger.info("Sending Event to Device over the URL: '" + url + "'");
		rest.postForLocation(url, event);
	}
}

package de.smartheating.SmartHeatingCommons.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.netflix.appinfo.AmazonInfo;

@Configuration
public class AwsConfiguration {
	
	@Value("${server.port}")
	private Integer applicationPort;

	@Bean
	@Profile("aws")
	public EurekaInstanceConfigBean eurekaInstanceConfig(InetUtils inetUtils) {
	  EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
	  AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
	  config.setDataCenterInfo(info);
	  config.setHostname(info.get(AmazonInfo.MetaDataKey.localHostname));
	  config.setIpAddress(info.get(AmazonInfo.MetaDataKey.localIpv4));
	  config.setNonSecurePort(applicationPort);
	  return config;
	}
}

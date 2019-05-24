package de.smartheating.SmartHeatingCommons.persistedData;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "sensors")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;

	@JsonProperty("module_name")
	private String sensorName;
	@JsonProperty("ip")
	private String ip;
	@JsonProperty("port")
	private Integer port;
	@JsonProperty("send_interval")
	private Integer sendInterval;
	@JsonProperty("reads_per_minute")
	private Integer readsPerMinute;
	@JsonProperty("value_type")
	private String valueType;
	@JsonProperty("script_path")
	private String scriptPath;

	public Long getId() {
		return id;
	}

	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getSendInterval() {
		return sendInterval;
	}

	public void setSendInterval(Integer sendInterval) {
		this.sendInterval = sendInterval;
	}

	public Integer getReadsPerMinute() {
		return readsPerMinute;
	}

	public void setReadsPerMinute(Integer readsPerMinute) {
		this.readsPerMinute = readsPerMinute;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getScriptPath() {
		return scriptPath;
	}

	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

}

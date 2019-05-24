package de.smartheating.SmartHeatingCommons.databaseInterfaces;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import de.smartheating.SmartHeatingCommons.persistedData.Sensor;

@Transactional
public interface SensorRepository extends CrudRepository<Sensor, Long> {

}

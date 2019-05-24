package de.smartheating.SmartHeatingCommons.databaseInterfaces;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import de.smartheating.SmartHeatingCommons.persistedData.SensorEvent;

@Transactional
public interface SensorEventRepository extends CrudRepository<SensorEvent, Long> {

}

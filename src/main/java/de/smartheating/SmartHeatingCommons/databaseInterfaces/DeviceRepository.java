package de.smartheating.SmartHeatingCommons.databaseInterfaces;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import de.smartheating.SmartHeatingCommons.persistedData.Device;

@Transactional
public interface DeviceRepository extends CrudRepository<Device, Long> {

}

package de.smartheating.SmartHeatingCommons.databaseInterfaces;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import de.smartheating.SmartHeatingCommons.persistedData.Event;

@Transactional
public interface EventRepository extends CrudRepository<Event, Long> {

}

package net.kraklups.photonwell.repositories;

import java.util.List;

import net.kraklups.photonwell.model.alarm.Alarm;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "alarm", path = "alarm")
public interface AlarmRepository extends MongoRepository<Alarm, String> {

	void delete (Alarm deleted);
	
	public List<Alarm> findAll();
	
	public Alarm findOne(String id);
	
	public List<Alarm> findByEventTskId(String eventTskId);
	
	@SuppressWarnings("unchecked")
	public Alarm save(Alarm saved);
}

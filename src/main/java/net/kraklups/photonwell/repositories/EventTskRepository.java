package net.kraklups.photonwell.repositories;

import java.util.List;

import net.kraklups.photonwell.model.eventtsk.EventTsk;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "eventtsk", path = "eventtsk")
public interface EventTskRepository extends MongoRepository<EventTsk, String> {

	void delete (EventTsk deleted);
	
	public List<EventTsk> findAll();
	
	public EventTsk findOne(String id);
	
	public EventTsk findByEventTskId(String eventTskId);
	
	@SuppressWarnings("unchecked")
	public EventTsk save(EventTsk saved);
}

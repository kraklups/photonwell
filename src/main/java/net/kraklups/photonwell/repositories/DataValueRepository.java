package net.kraklups.photonwell.repositories;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValue;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "datavalue", path = "datavalue")
public interface DataValueRepository extends MongoRepository<DataValue, String> {

	void delete (DataValue deleted);
	
	public List<DataValue> findAll();
	
	public DataValue findOne(String id);
	
	public DataValue findByDataValueId(String dataValueId);
	
	@SuppressWarnings("unchecked")
	public DataValue save(DataValue saved);
}

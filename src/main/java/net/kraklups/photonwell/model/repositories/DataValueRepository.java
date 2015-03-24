package net.kraklups.photonwell.model.repositories;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValue;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pw", path = "pw")
public interface DataValueRepository extends MongoRepository<DataValue, String> {

	void delete (DataValue deleted);
	
	public List<DataValue> findAll();
	
	public DataValue findOne(String dataValueId);
	
	@SuppressWarnings("unchecked")
	public DataValue save(DataValue saved);
}

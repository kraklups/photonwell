package net.kraklups.photonwell.model.datavalueservice;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValue;

import org.springframework.data.repository.CrudRepository;

public interface DataValueRepository extends CrudRepository<DataValue, String> {

	void delete (DataValue deleted);
	
	List<DataValue> findAll();
	
	DataValue findOne(String dataValueId);
	
	DataValue save(DataValue saved);
}

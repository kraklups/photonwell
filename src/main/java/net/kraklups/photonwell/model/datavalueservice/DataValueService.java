package net.kraklups.photonwell.model.datavalueservice;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValue;

public interface DataValueService {
	
	public DataValue create(DataValue dataValue);
	
	public DataValue delete(String id);
	
	public List<DataValue> findAll();
	
	public DataValue findById(String id);
	
	public DataValue update(DataValue dataValue);

}

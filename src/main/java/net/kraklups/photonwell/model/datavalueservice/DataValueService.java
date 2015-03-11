package net.kraklups.photonwell.model.datavalueservice;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValueDTO;

public interface DataValueService {
	
	DataValueDTO create(DataValueDTO dataValue);
	
	DataValueDTO delete(String dataValueId);
	
	List<DataValueDTO> findAll();
	
	DataValueDTO findBy(String dataValueId);
	
	DataValueDTO update(DataValueDTO dataValue);

}

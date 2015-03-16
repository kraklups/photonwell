package net.kraklups.photonwell.model.datavalueservice;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValueDTO;

public interface DataValueService {
	
	DataValueDTO create(DataValueDTO dataValue);
	
	DataValueDTO delete(String id);
	
	List<DataValueDTO> findAll();
	
	DataValueDTO findById(String id);
	
	DataValueDTO update(DataValueDTO dataValue);

}

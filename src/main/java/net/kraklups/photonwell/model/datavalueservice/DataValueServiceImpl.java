package net.kraklups.photonwell.model.datavalueservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValue;
import net.kraklups.photonwell.model.datavalue.DataValueDTO;
import net.kraklups.photonwell.util.DataValueNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class DataValueServiceImpl  implements DataValueService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataValueServiceImpl.class);
	
	private final DataValueRepository repository;
	
	@Autowired
	public DataValueServiceImpl(DataValueRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public DataValueDTO create(DataValueDTO dataValue) {

		LOGGER.info("Creating a new dataValue entry with information: {}", dataValue);
		
		DataValue persisted = new DataValue(
				dataValue.getDataValueId(),
				dataValue.getTaskPrkId(),
				dataValue.getElementPrkId(),
				dataValue.getDataLoggerId(),
				dataValue.getSensorId(),
				dataValue.getDtValue(),
				dataValue.getDtType());
		
		persisted = repository.save(persisted);
		
		LOGGER.info("Created a new dataValue entry with information: {}", persisted);
		
		return convertToDTO(persisted);
	}

	@Override
	public DataValueDTO delete(String id) {
		LOGGER.info("Deleting a todo entry with id: {}", id);
		
		DataValue deleted = findDataValueById(id);
        repository.delete(deleted);

        LOGGER.info("Deleted todo entry with informtation: {}", deleted);

        return convertToDTO(deleted);
	}

	@Override
	public List<DataValueDTO> findAll() {
		LOGGER.info("Finding all todo entries.");

        List<DataValue> dataValueEntries = repository.findAll();

        LOGGER.info("Found {} todo entries", dataValueEntries.size());

        return convertToDTOs(dataValueEntries);
	}

	private List<DataValueDTO> convertToDTOs(List<DataValue> models) {
		
		List<DataValueDTO> listDt = new ArrayList<DataValueDTO>();
		
		Iterator<DataValue> iterator = models.iterator();
		
		while (iterator.hasNext()) {
			listDt.add(convertToDTO(iterator.next()));
		}
		
		return listDt;		
    }
	
	@Override
	public DataValueDTO findById(String id) {
	    LOGGER.info("Finding todo entry with id: {}", id);

        DataValue found = findDataValueById(id);

        LOGGER.info("Found todo entry: {}", found);

        return convertToDTO(found);
    }

	@Override
	public DataValueDTO update(DataValueDTO dataValue) {
	    LOGGER.info("Updating dataValue entry with information: {}", dataValue);

	    DataValue updated = findDataValueById(dataValue.getId());
        updated.update(dataValue.getDataValueId(), dataValue.getTaskPrkId(), dataValue.getElementPrkId(), 
        		dataValue.getDataLoggerId(), dataValue.getSensorId(), dataValue.getDtValue(), dataValue.getDtType());
        updated = repository.save(updated);

        LOGGER.info("Updated todo entry with information: {}", updated);

        return convertToDTO(updated);
	}

	private DataValue findDataValueById(String id) {
        DataValue result = repository.findOne(id);
        
        if (result == null) {
        	throw new DataValueNotFoundException(id);
        } else {
        	return result;
        }
    }

	private DataValueDTO convertToDTO(DataValue model) {
		DataValueDTO dto = new DataValueDTO();

		dto.setId(model.getId());
		dto.setDataValueId(model.getDataValueId());
		dto.setTaskPrkId(model.getTaskPrkId());
		dto.setElementPrkId(model.getElementPrkId());
		dto.setDataLoggerId(model.getDataLoggerId());
		dto.setSensorId(model.getSensorId());
		dto.setDtType(model.getDtType());
		dto.setDtValue(model.getDtValue());

		return dto;
	}	
	
}

package net.kraklups.photonwell.model.datavalueservice;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValue;
import net.kraklups.photonwell.model.datavalue.SeqDataValueService;
import net.kraklups.photonwell.repositories.DataValueRepository;
import net.kraklups.photonwell.util.DataValueNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class DataValueServiceImpl  implements DataValueService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataValueServiceImpl.class);
	
	private static final String DATAVALUE_SEQ_KEY = "datavalue";
	
	@Autowired
	private SeqDataValueService seqDataValueService;
	
	@Autowired
	private final DataValueRepository repository;
	
	@Autowired
	public DataValueServiceImpl(DataValueRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public DataValue create(DataValue dt) {

		LOGGER.info("Creating a new dataValue entry with information: {}", dt.getDataValueId());
		
		DataValue persisted = new DataValue(dt.getDataValueId(), dt.getTaskPrkId(), dt.getElementPrkId(),
				dt.getDataLoggerId(), dt.getSensorId(), dt.getDtValue(), dt.getDtType());
		
		persisted.setId(seqDataValueService.getNextSeqDataValueId(DATAVALUE_SEQ_KEY));
		
		persisted = repository.save(persisted);
		
		LOGGER.info("Created a new dataValue entry with information: {}", persisted);
		
		return persisted;
	}

	@Override
	public DataValue delete(String id) {
		LOGGER.info("Deleting a todo entry with id: {}", id);
		
		DataValue deleted = findDataValueById(id);
        repository.delete(deleted);

        LOGGER.info("Deleted todo entry with informtation: {}", deleted);

        return deleted;
	}

	@Override
	public List<DataValue> findAll() {
		LOGGER.info("Finding all todo entries.");

        List<DataValue> dataValueEntries = repository.findAll();

        LOGGER.info("Found {} todo entries", dataValueEntries.size());

        return dataValueEntries;
	}
	
	@Override
	public DataValue findById(String id) {
	    LOGGER.info("Finding todo entry with id: {}", id);

        DataValue found = findDataValueById(id);

        LOGGER.info("Found todo entry: {}", found);

        return found;
    }

	@Override
	public DataValue update(DataValue dataValue) {
	    LOGGER.info("Updating dataValue entry with information: {}", dataValue);
/*
	    DataValue updated = findDataValueById(dataValue.getId());
        updated.update(dataValue.getDataValueId(), dataValue.getTaskPrkId(), dataValue.getElementPrkId(), 
        		dataValue.getDataLoggerId(), dataValue.getSensorId(), dataValue.getDtValue(), dataValue.getDtType());
        updated = repository.save(updated);

        LOGGER.info("Updated todo entry with information: {}", updated);

        return updated;
*/
	    return null;
	}

	private DataValue findDataValueById(String id) {
        DataValue result = repository.findOne(id);
        
        if (result == null) {
        	throw new DataValueNotFoundException(id);
        } else {
        	return result;
        }
    }
	
}

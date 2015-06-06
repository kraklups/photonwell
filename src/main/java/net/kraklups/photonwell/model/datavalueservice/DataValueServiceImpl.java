package net.kraklups.photonwell.model.datavalueservice;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.mapreduce.MapReduceOptions.options;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import net.kraklups.photonwell.model.datavalue.DataValue;
import net.kraklups.photonwell.model.datavalue.SeqDataValueService;
import net.kraklups.photonwell.model.datavalue.ValueObject;
import net.kraklups.photonwell.repositories.DataValueRepository;
import net.kraklups.photonwell.util.DataValueNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
final class DataValueServiceImpl implements DataValueService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataValueServiceImpl.class);
	
	private static final String DATAVALUE_SEQ_KEY = "datavalue";
	
	@Autowired
	private SeqDataValueService seqDataValueService;
	
	@Autowired
	private final DataValueRepository repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired 
	private MongoOperations mongoOperations; 
	
	@Autowired
	public DataValueServiceImpl(DataValueRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public DataValue create(DataValue dt) {

		LOGGER.info("Creating a new dataValue entry with information: {}", dt.getDataValueId());
		
		DataValue persisted = new DataValue(dt.getDataValueId(), dt.getTaskPrkId(), dt.getElementPrkId(),
				dt.getDataLoggerId(), dt.getSensorId(), dt.getDtValue(), dt.getDtType(), dt.getFixedPoint());
		
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

	private DataValue findDataValueById(String dataValueId) {
        DataValue result = repository.findByDataValueId(dataValueId);
        
        if (result == null) {
        	throw new DataValueNotFoundException(dataValueId);
        } else {
        	return result;
        }
    }

	@Override
	public List<ValueObject> mapReduceDataValue(String dataValueId) throws Exception {
		
		long epoch = 1047423600;
		int i;
		String ini, fin;
		Date to, from;
		
		// LOGGER.info("Updating dataValue entry with information: {}", mongoOperations.findAll(DataValue.class).size());
				
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

		List<ValueObject> valObj = new ArrayList<>();
		
		//final Date to = dateFormat.parse("2003-03-13T00:00:00.000Z"); //tiemstamp end: 1049245200
		//final Date from = dateFormat.parse("2003-03-12T00:00:00.000Z"); //timestamp begin: 1047427200		
		// String ddd = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new java.util.Date (epoch*1000));		
		
		for(i=0;i<20;i++) {			
			ini = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new java.util.Date (epoch*1000));
			fin = new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(new java.util.Date ((epoch+86400)*1000));
		
			to = dateFormat.parse(fin);
			from = dateFormat.parse(ini);

			Query query = new Query();
			
			query.addCriteria(Criteria.where("fixedPoint").lte(to).gte(from));
			
			MapReduceResults<ValueObject> results = mongoTemplate.mapReduce(query,"datavalue","classpath:mapreducejs/map.js","classpath:mapreducejs/reduce.js",ValueObject.class);
			for (ValueObject valueObject : results) {				
				valueObject.setId(ini);				
				valObj.add(valueObject);
			}
			
			epoch += 86400;
		}	
		
		return valObj;
	}
	
}

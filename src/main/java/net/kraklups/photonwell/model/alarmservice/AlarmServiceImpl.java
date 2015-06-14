package net.kraklups.photonwell.model.alarmservice;

import java.util.List;

import net.kraklups.photonwell.model.alarm.Alarm;
import net.kraklups.photonwell.model.alarm.AlarmDTO;
import net.kraklups.photonwell.model.alarm.SeqAlarmService;
import net.kraklups.photonwell.repositories.AlarmRepository;
import net.kraklups.photonwell.util.RestServiceURL;
import net.kraklups.photonwell.util.SeqAlarmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
final class AlarmServiceImpl  implements AlarmService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmServiceImpl.class);
	
	private static final String ALARM_SEQ_KEY = "alarm";
	
	@Autowired
	private SeqAlarmService seqAlarmService;
	
	@Autowired
	private final AlarmRepository repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;	
	
    @Autowired
    @Qualifier("urlAlarmTriggeredREST")
    private RestServiceURL urlAlarmTriggeredREST;
    
	@Autowired
	public AlarmServiceImpl(AlarmRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Alarm create(Alarm alarm) 
			throws SeqAlarmException, Exception {

		LOGGER.info("Creating a new alarm entry with information: {}", alarm.getEventTskId());
		
		Alarm persisted = new Alarm(alarm.getTriggerDate(), 
				alarm.getEventTskId(), alarm.getRuleEventTsk());
		
		persisted.setId(seqAlarmService.getNextSeqAlarmId(ALARM_SEQ_KEY));
		
		persisted = repository.save(persisted);		
		
		alarmTriggered(persisted);
		
		LOGGER.info("Created a new alarm entry with information: {}", persisted);
		
		return persisted;
	}

	@Override
	public Alarm delete(String id) {
		LOGGER.info("Deleting a Alarm entry with id: {}", id);
		
		Alarm deleted = repository.findOne(id);
        repository.delete(deleted);

        LOGGER.info("Deleted todo entry with informtation: {}", deleted);

        return deleted;
	}

	@Override
	public List<Alarm> findAll() {
		LOGGER.info("Finding all Alarms todo entries.");

        List<Alarm> alarmEntries = repository.findAll();

        LOGGER.info("Found {} todo entries", alarmEntries.size());

        return alarmEntries;
	}
		
	@Override
	public Alarm update(Alarm alarm) {
	    LOGGER.info("Updating Alarm entry with information: {}", alarm);
/*
	    Alarm updated = findAlarmById(alarm.getId());
        updated.update(alarm.getEventTskId(), alarm.getAlarmId(), 
        		alarm.getTriggerDate(), alarm.getRuleEventTsk());
        updated = repository.save(updated);

        LOGGER.info("Updated todo entry with information: {}", updated);

        return updated; */
	    
	    return null;
	}

	@Override
	public void alarmTriggered(Alarm alarm) 
			throws Exception {
		
		final String SERVER_URI = urlAlarmTriggeredREST.getUrlREST().toString(); 
		
		LOGGER.debug("Starting REST Client!!!!");
			
		RestTemplate restTemplate = new RestTemplate();
		
		AlarmDTO alarmDTO = new AlarmDTO(alarm.getTriggerDate(), alarm.getEventTskId(), alarm.getRuleEventTsk());
								
		try {
			
			ResponseEntity<AlarmDTO> responseEntity = restTemplate.postForEntity(SERVER_URI, alarmDTO, AlarmDTO.class);
			
		//	Integer response = restTemplate.getForObject("http://localhost:9090/solar-app/rest/alarmTriggered/1", Integer.class);
	            			
			AlarmDTO response = responseEntity.getBody();
			
			System.out.println("merde: " + response);

		}catch(HttpStatusCodeException e){
			String errorpayload = e.getResponseBodyAsString();
			System.out.println("nadia: " + errorpayload);
			
		} catch(RestClientException e){
			 
		}		
				
	}

	@Override
	public Alarm findById(String id) {
		
		Query query = new Query(Criteria.where("_id").is(Long.parseLong(id)));
		
		Alarm found = mongoTemplate.findOne(query,Alarm.class);
		
		System.out.println("Found todo entry: " + found);
		
		return found;
	}
	
}

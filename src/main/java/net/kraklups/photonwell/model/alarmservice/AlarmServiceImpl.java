package net.kraklups.photonwell.model.alarmservice;

import java.util.List;

import net.kraklups.photonwell.model.alarm.Alarm;
import net.kraklups.photonwell.model.alarm.SeqAlarmService;
import net.kraklups.photonwell.repositories.AlarmRepository;
import net.kraklups.photonwell.util.DataValueNotFoundException;
import net.kraklups.photonwell.util.SeqAlarmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class AlarmServiceImpl  implements AlarmService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmServiceImpl.class);
	
	private static final String ALARM_SEQ_KEY = "alarm";
	
	@Autowired
	private SeqAlarmService seqAlarmService;
	
	@Autowired
	private final AlarmRepository repository;
	
	@Autowired
	public AlarmServiceImpl(AlarmRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Alarm create(Alarm alarm) throws SeqAlarmException {

		LOGGER.info("Creating a new alarm entry with information: {}", alarm.getEventTskId());
		
		Alarm persisted = new Alarm(alarm.getEventTskId(), alarm.getAlarmId(), 
        		alarm.getTriggerDate(), alarm.getRuleEventTsk());
		
		persisted.setId(seqAlarmService.getNextSeqAlarmId(ALARM_SEQ_KEY));
		
		persisted = repository.save(persisted);
		
		LOGGER.info("Created a new alarm entry with information: {}", persisted);
		
		return persisted;
	}

	@Override
	public Alarm delete(String id) {
		LOGGER.info("Deleting a todo entry with id: {}", id);
		
		Alarm deleted = findAlarmById(id);
        repository.delete(deleted);

        LOGGER.info("Deleted todo entry with informtation: {}", deleted);

        return deleted;
	}

	@Override
	public List<Alarm> findAll() {
		LOGGER.info("Finding all todo entries.");

        List<Alarm> alarmEntries = repository.findAll();

        LOGGER.info("Found {} todo entries", alarmEntries.size());

        return alarmEntries;
	}
	
	@Override
	public Alarm findById(String id) {
	    LOGGER.info("Finding todo entry with id: {}", id);

	    Alarm found = findAlarmById(id);

        LOGGER.info("Found todo entry: {}", found);

        return found;
    }
	
	@Override
	public Alarm update(Alarm alarm) {
	    LOGGER.info("Updating dataValue entry with information: {}", alarm);
/*
	    Alarm updated = findAlarmById(alarm.getId());
        updated.update(alarm.getEventTskId(), alarm.getAlarmId(), 
        		alarm.getTriggerDate(), alarm.getRuleEventTsk());
        updated = repository.save(updated);

        LOGGER.info("Updated todo entry with information: {}", updated);

        return updated; */
	    
	    return null;
	}

	private Alarm findAlarmById(String id) {
		Alarm result = repository.findOne(id);
        
        if (result == null) {
        	throw new DataValueNotFoundException(id);
        } else {
        	return result;
        }
    }
	
}

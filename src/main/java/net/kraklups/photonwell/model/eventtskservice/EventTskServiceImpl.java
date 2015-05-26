package net.kraklups.photonwell.model.eventtskservice;

import java.util.List;

import net.kraklups.photonwell.model.eventtsk.EventTsk;
import net.kraklups.photonwell.model.eventtsk.SeqEventTskService;
import net.kraklups.photonwell.repositories.EventTskRepository;
import net.kraklups.photonwell.util.EventTskNotFoundException;
import net.kraklups.photonwell.util.SeqEventTskException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final class EventTskServiceImpl  implements EventTskService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventTskServiceImpl.class);
	
	private static final String EVENTTSK_SEQ_KEY = "eventtsk";
	
	@Autowired
	private SeqEventTskService seqEventTskService;
	
	@Autowired
	private final EventTskRepository repository;
	
	@Autowired
	public EventTskServiceImpl(EventTskRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public EventTsk create(EventTsk eventTsk) throws SeqEventTskException {

		LOGGER.info("Creating a new eventTsk entry with information: {}", eventTsk.getEventTskId());
		
		EventTsk persisted = new EventTsk(eventTsk.getEventTskId(), eventTsk.getSynchronizeId(),  eventTsk.getDataValueId(),
        		eventTsk.getTvi(), eventTsk.getTvf(), eventTsk.getRuleEventTsk());
		
		persisted.setId(seqEventTskService.getNextSeqEventTskId(EVENTTSK_SEQ_KEY));
		
		persisted = repository.save(persisted);
		
		LOGGER.info("Created a new eventTsk entry with information: {}", persisted);
		
		return persisted;
	}

	@Override
	public EventTsk delete(String eventTskId) {
		LOGGER.info("Deleting a EventTsk entry with id: {}", eventTskId);
		
		EventTsk deleted = findEventTskById(eventTskId);
        repository.delete(deleted);

        LOGGER.info("Deleted todo entry with informtation: {}", deleted);

        return deleted;
	}

	@Override
	public List<EventTsk> findAll() {
		LOGGER.info("Finding all EventTsks todo entries.");

        List<EventTsk> eventTskEntries = repository.findAll();

        LOGGER.info("Found {} todo entries", eventTskEntries.size());

        return eventTskEntries;
	}
	
	@Override
	public EventTsk findById(String eventTskId) {
	    LOGGER.info("Finding EventTsk entry with id: {}", eventTskId);

	    EventTsk found = findEventTskById(eventTskId);

        LOGGER.info("Found todo entry: {}", found);

        return found;
    }
	
	@Override
	public EventTsk update(EventTsk eventTsk) {
	    LOGGER.info("Updating EventTsk entry with information: {}", eventTsk);
/*
	    EventTsk updated = findEventTskById(eventTsk.getId());
        updated.update(eventTsk.getEventTskId(), eventTsk.getEventTskId(), 
        		eventTsk.getTriggerDate(), eventTsk.getRuleEventTsk());
        updated = repository.save(updated);

        LOGGER.info("Updated todo entry with information: {}", updated);

        return updated; */
	    
	    return null;
	}

	private EventTsk findEventTskById(String eventTskId) {
		EventTsk result = repository.findByEventTskId(eventTskId);
        
        if (result == null) {
        	throw new EventTskNotFoundException(eventTskId);
        } else {
        	return result;
        }
    }
	
}

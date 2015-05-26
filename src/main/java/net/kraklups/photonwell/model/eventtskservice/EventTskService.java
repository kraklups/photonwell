package net.kraklups.photonwell.model.eventtskservice;

import java.util.List;

import net.kraklups.photonwell.model.eventtsk.EventTsk;

public interface EventTskService {
	
	public EventTsk create(EventTsk eventTsk);
	
	public EventTsk delete(String eventTskId);
	
	public List<EventTsk> findAll();
	
	public EventTsk findById(String eventTskId);
	
	public EventTsk update(EventTsk eventTsk);

}

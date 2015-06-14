package net.kraklups.photonwell.model.alarmservice;

import java.util.List;

import net.kraklups.photonwell.model.alarm.Alarm;

public interface AlarmService {
	
	public Alarm create(Alarm alarm) throws Exception;
	
	public Alarm delete(String alarmId);
	
	public List<Alarm> findAll();
		
	public Alarm update(Alarm alarm);
	
	public Alarm findById(String id);
	
	public void alarmTriggered(Alarm alarm) throws Exception;

}

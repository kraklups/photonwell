package net.kraklups.photonwell.model.alarmservice;

import java.util.List;

import net.kraklups.photonwell.model.alarm.Alarm;

public interface AlarmService {
	
	public Alarm create(Alarm alarm);
	
	public Alarm delete(String id);
	
	public List<Alarm> findAll();
	
	public Alarm findById(String id);
	
	public Alarm update(Alarm alarm);

}

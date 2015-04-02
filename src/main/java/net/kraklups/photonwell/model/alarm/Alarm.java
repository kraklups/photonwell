package net.kraklups.photonwell.model.alarm;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection="alarm")
public class Alarm {

	@Id
	private String id;
	
	@Field
	private String eventTskId;
	
	@Field
	private String alarmId;
	
	@Field
	private Date triggerDate;
	
	@Field
	private String ruleEventTsk;
	
	public Alarm() {
		// TODO Auto-generated constructor stub
	}
	
	public Alarm(String id, String eventTskId, String alarmId, Date triggerDate, String ruleEventTsk) {
		this.id = id;
		this.eventTskId = eventTskId;
		this.alarmId = alarmId;
		this.triggerDate = triggerDate;
		this.ruleEventTsk = ruleEventTsk;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}	

	public String getEventTskId() {
		return eventTskId;
	}
	
	public void setEventTskId(String eventTskId) {
		this.eventTskId = eventTskId;
	}	
	
	public String getAlarmId() {
		return alarmId;
	}
	
	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}	

	public Date getTriggerDate() {
		return triggerDate;
	}
	
	public void setTriggerDate(Date triggerDate) {
		this.triggerDate = triggerDate;
	}		
	
	public String getRuleEventTsk() {
		return ruleEventTsk;
	}
	
	public void setrulEEventTsk(String ruleEventTsk) {
		this.ruleEventTsk = ruleEventTsk;
	}
	
	public void update(String id, String eventTskId, String alarmId, Date triggerDate, String ruleEventTsk) {
		this.id = id;
		this.eventTskId = eventTskId;
		this.alarmId = alarmId;
		this.triggerDate = triggerDate;
		this.ruleEventTsk = ruleEventTsk;
	}	
	
	@Override
    public String toString() {
        return "AlarmMngDb [eventTskId=" + eventTskId + ", alarmId=" + alarmId + 
        		", triggerDate=" + triggerDate + ", ruleEventTsk=" + ruleEventTsk + "]";
    }
	
}

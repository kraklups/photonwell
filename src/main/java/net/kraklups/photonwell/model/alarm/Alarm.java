package net.kraklups.photonwell.model.alarm;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Document (collection="alarm")
public class Alarm implements java.io.Serializable {

	private static final long serialVersionUID = -3935145548645668227L;

	@Id
	private long id;
	
	@Field
	private String eventTskId;
	
	@Field
	private Date triggerDate;
	
	@Field
	private String ruleEventTsk;
	
	public Alarm() {
	}
	
	public Alarm(Date triggerDate, String eventTskId, String ruleEventTsk) {
		this.eventTskId = eventTskId;
		this.triggerDate = triggerDate;
		this.ruleEventTsk = ruleEventTsk;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}	

	public String getEventTskId() {
		return eventTskId;
	}
	
	public void setEventTskId(String eventTskId) {
		this.eventTskId = eventTskId;
	}	
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getTriggerDate() {
		return triggerDate;
	}
	
	@JsonDeserialize(using=DateDeserializer.class)
	public void setTriggerDate(Date triggerDate) {
		this.triggerDate = triggerDate;
	}		
	
	public String getRuleEventTsk() {
		return ruleEventTsk;
	}
	
	public void setRuleEventTsk(String ruleEventTsk) {
		this.ruleEventTsk = ruleEventTsk;
	}
	
	public void update(String eventTskId, Date triggerDate, String ruleEventTsk) {
		this.eventTskId = eventTskId;
		this.triggerDate = triggerDate;
		this.ruleEventTsk = ruleEventTsk;
	}	
	
	@Override
    public String toString() {
        return "AlarmMngDb [eventTskId=" + eventTskId + 
        		", triggerDate=" + triggerDate + ", ruleEventTsk=" + ruleEventTsk + "]";
    }	
}

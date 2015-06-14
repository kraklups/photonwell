package net.kraklups.photonwell.model.alarm;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class AlarmDTO implements java.io.Serializable {
	
	private static final long serialVersionUID = -6265856995241815492L;

	private Date triggerDate;	
		
	private String eventTskId;
	
	private String ruleEventTsk;
	
	public AlarmDTO() {		
	}
	
	public AlarmDTO(Date triggerDate, String eventTskId, String ruleEventTsk) {
		this.eventTskId = eventTskId;
		this.triggerDate = triggerDate;
		this.ruleEventTsk = ruleEventTsk;
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
			
	@Override
    public String toString() {
        return "AlarmMngDb [eventTskId=" + eventTskId +  
        		", triggerDate=" + triggerDate + ", ruleEventTsk=" + ruleEventTsk + "]";
    }	
}

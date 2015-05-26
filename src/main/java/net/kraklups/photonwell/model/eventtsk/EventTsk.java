package net.kraklups.photonwell.model.eventtsk;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection="eventtsk")
public class EventTsk {

	@Id
	private long id;
	
	@Field
	private String eventTskId;
	
	@Field
	private String synchronizeId;

	@Field
	private String dataValueId;
	
	@Field
	private Date tvi;
	
	@Field
	private Date tvf;

	@Field
	private String ruleEventTsk;
	
	public EventTsk() {
		// TODO Auto-generated constructor stub
	}
	
	public EventTsk(String eventTskId, String synchronizeId, Date tvi, Date tvf, String ruleEventTsk) {
		this.eventTskId = eventTskId;
		this.synchronizeId = synchronizeId;
		this.tvi = tvi;
		this.tvf = tvf;
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
	
	public String getSynchronizeId() {
		return synchronizeId;
	}
	
	public void setSynchronizeId(String synchronizeId) {
		this.synchronizeId = synchronizeId;
	}	

	public Date getTvi() {
		return tvi;
	}
	
	public void setTvi(Date tvi) {
		this.tvi = tvi;
	}		

	public Date getTvf() {
		return tvf;
	}
	
	public void setTvf(Date tvf) {
		this.tvf = tvf;
	}			
	
	public String getRuleEventTsk() {
		return ruleEventTsk;
	}
	
	public void setrulEEventTsk(String ruleEventTsk) {
		this.ruleEventTsk = ruleEventTsk;
	}
	
	public void update(String eventTskId, String synchronizeId, Date tvi, Date tvf, String ruleEventTsk) {
		this.eventTskId = eventTskId;
		this.synchronizeId = synchronizeId;
		this.tvi = tvi;
		this.tvf = tvf;
		this.ruleEventTsk = ruleEventTsk;
	}	
	
	@Override
    public String toString() {
        return "EventTskMngDb [eventTskId=" + eventTskId + ", synchronizeId=" + synchronizeId + 
        		", tvi=" + tvi + ", tvf=" + tvf + ", ruleEventTsk=" + ruleEventTsk + "]";
    }
	
}

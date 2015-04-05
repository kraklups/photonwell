package net.kraklups.photonwell.model.alarm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seqalarm")
public class SeqAlarm {

	@Id
	private String id;
	
	private long seq;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public long getSeqAlarm() {
		return seq;
	}
	
	public void setSetAlarm(long seq) {
		this.seq = seq;
	}	
	
	@Override
	public String toString() {
		return "SeqAlarm [id=" + id + ", seqAlarm=" + seq + "]";
	}	
	
}

package net.kraklups.photonwell.model.eventtsk;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seqeventtsk")
public class SeqEventTsk {

	@Id
	private String id;
	
	private long seq;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public long getSeqEventTsk() {
		return seq;
	}
	
	public void setSetEventTsk(long seq) {
		this.seq = seq;
	}	
	
	@Override
	public String toString() {
		return "SeqEventTsk [id=" + id + ", seqEventTsk=" + seq + "]";
	}	
	
}
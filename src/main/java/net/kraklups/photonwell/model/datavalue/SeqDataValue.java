package net.kraklups.photonwell.model.datavalue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seqdatavalue")
public class SeqDataValue {

	@Id
	private String id;
	
	private long seq;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public long getSeqDataValue() {
		return seq;
	}
	
	public void setSetDataValue(long seq) {
		this.seq = seq;
	}	
	
	@Override
	public String toString() {
		return "SeqDataValue [id=" + id + ", seqDataValue=" + seq + "]";
	}	

}

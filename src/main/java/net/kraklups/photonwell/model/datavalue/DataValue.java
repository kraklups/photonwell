package net.kraklups.photonwell.model.datavalue;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection="datavalue")
public class DataValue {

	@Id
	private long id;
	
	@Field
	private String dataValueId;
	
	@Field
	private String taskPrkId;
	
	@Field
	private String elementPrkId;
	
	@Field
	private String dataLoggerId;
	
	@Field
	private String sensorId;   
	
	@Field
	private String dtValue;
	
	@Field
	private String dtType;
		
	public DataValue() {
		
	}
	
	public DataValue(String dataValueId, String taskPrkId, String elementPrkId, 
    		String dataLoggerId, String sensorId, String dtValue, String dtType) {
		this.dataValueId = dataValueId;
		this.taskPrkId = taskPrkId;
		this.elementPrkId = elementPrkId;
		this.dataLoggerId = dataLoggerId;
		this.sensorId = sensorId;
		this.dtValue = dtValue;
		this.dtType = dtType;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}	
		
	public String getDataValueId() {
		return dataValueId;
	}	
	
	public void setDataValueId(String dataValueId) {
		this.dataValueId = dataValueId;
	}
		
	public String getTaskPrkId() {
		return taskPrkId;
	}

	public void setTaskPrkId(String taskPrkId) {
		this.taskPrkId = taskPrkId;
	}
	
	public String getElementPrkId() {
		return elementPrkId;
	}

	public void setElementPrkId(String elementPrkId) {
		this.elementPrkId = elementPrkId;
	}

	public String getDataLoggerId() {
		return dataLoggerId;
	}

	public void setDataLoggerId(String dataLoggerId) {
		this.dataLoggerId = dataLoggerId;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}
	
	public String getDtValue() {
		return dtValue;
	}
	
	public void setDtValue(String dtValue) {
		this.dtValue = dtValue;
	}

	public String getDtType() {
		return dtType;
	}

	public void setDtType(String dtType) {
		this.dtType = dtType;
	}

    public void update(String dataValueId, String taskPrkId, String elementPrkId, 
    		String dataLoggerId, String sensorId, String dtValue, String dtType) {
    	
        this.dataValueId = dataValueId;
        this.taskPrkId = taskPrkId;
        this.elementPrkId = elementPrkId;
        this.dataLoggerId = dataLoggerId;
        this.sensorId = sensorId;
        this.dtValue = dtValue;
        this.dtType = dtType;     
    }	
	
	@Override
    public String toString() {
        return "DataValueMngDb [dataValueId=" + dataValueId + ", TaskPrk=" + taskPrkId + 
        		", ElementPrk=" + elementPrkId + ", DataLogger=" + dataLoggerId + 
        		", Sensor=" + sensorId + ", value=" + dtValue + ", type=" + dtType + "]";
    }	
	
	
}

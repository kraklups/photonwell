package net.kraklups.photonwell.model.datavalue;

import org.hibernate.validator.constraints.NotEmpty;

public final class DataValueDTO {

	private String id;
	
	@NotEmpty
	private String dataValueId;
	
	@NotEmpty
	private String taskPrkId;
	
	@NotEmpty
	private String elementPrkId;
	
	@NotEmpty
	private String dataLoggerId;
	
	@NotEmpty
	private String sensorId;   
	
	@NotEmpty
	private String dtValue;
	
	@NotEmpty
	private String dtType;

	public DataValueDTO() {	
	}	
	
	public DataValueDTO(String dataValueId, String taskPrkId, String elementPrkId, String dataLoggerId, 
			String sensorId, String dtValue, String dtType) {
		
		this.dataValueId = dataValueId;
		this.taskPrkId = taskPrkId;
		this.elementPrkId = elementPrkId;
		this.dataLoggerId = dataLoggerId;
		this.sensorId = sensorId;
		this.dtType = dtType;
		this.dtValue = dtValue;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
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

	@Override
    public String toString() {
        return "DataValueMngDb [dataValueId=" + dataValueId + ", TaskPrk=" + taskPrkId + 
        		", ElementPrk=" + elementPrkId + ", DataLogger=" + dataLoggerId + 
        		", Sensor=" + sensorId + ", value=" + dtValue + ", type=" + dtType + "]";
    }		
	
}

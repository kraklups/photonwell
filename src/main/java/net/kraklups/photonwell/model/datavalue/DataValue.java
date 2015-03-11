package net.kraklups.photonwell.model.datavalue;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection="DataValue")
public class DataValue {

	@Id
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
		// TODO Auto-generated constructor stub
	}
	
	public DataValue(String taskPrkId, String elementPrkId, String dataLoggerId, String sensorId, String dtValue, String dtType) {
		this.taskPrkId =taskPrkId;
		this.elementPrkId = elementPrkId;
		this.dataLoggerId = dataLoggerId;
		this.sensorId = sensorId;
		this.dtValue = dtValue;
		this.dtType = dtType;
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

	public String getelEmentPrkId() {
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

	public String getDtTypeId() {
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

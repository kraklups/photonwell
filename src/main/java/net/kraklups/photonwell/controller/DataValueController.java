package net.kraklups.photonwell.controller;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.photonwell.model.datavalue.DataValue;
import net.kraklups.photonwell.model.datavalueservice.DataValueService;
import net.kraklups.photonwell.util.DataValueNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/rest")
final class DataValueController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataValueController.class);
	
	@Autowired
	private final DataValueService service;
	
	@Autowired
	public DataValueController(DataValueService service) {
		this.service = service;
	}

	@RequestMapping(value = "/adddatavalue", method = RequestMethod.POST)
	public @ResponseBody DataValue create(@RequestBody @Valid DataValue dataValue) {
		return service.create(dataValue);
	}
	
	@RequestMapping(value = "/getdatavalues", method = RequestMethod.GET)
    public List<DataValue> findAll() {
        return service.findAll();
    }		

	@RequestMapping(value = "/getdatavalue/{dataValueId}", method = RequestMethod.GET)
    public DataValue findDataValue(@PathVariable String dataValueId) {
        return service.findById(dataValueId);
    }		
	
	
	@RequestMapping(value = "/mrdatavalue", method = RequestMethod.GET)
    public List<DataValue> mapReduceDataValue() {
        return service.findAll();
    }	
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleDataValueNotFound(DataValueNotFoundException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}

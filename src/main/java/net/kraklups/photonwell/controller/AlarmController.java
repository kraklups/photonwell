package net.kraklups.photonwell.controller;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.photonwell.model.alarm.Alarm;
import net.kraklups.photonwell.model.alarmservice.AlarmService;
import net.kraklups.photonwell.util.AlarmNotFoundException;

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
final class AlarmController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlarmController.class);
	
	@Autowired
	private final AlarmService service;
	
	@Autowired
	public AlarmController(AlarmService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/addalarm", method = RequestMethod.POST, headers="Accept=application/json", consumes = "application/json", produces = "application/json")
	public @ResponseBody Alarm create(@RequestBody @Valid Alarm alarm) 
			throws Exception {
		
		return service.create(alarm);
	}
	
	@RequestMapping(value = "/getalarms", method = RequestMethod.GET)
    public List<Alarm> findAll() {
        return service.findAll();
    }		

	@RequestMapping(value = "/getalarm/{id}", method = RequestMethod.GET)
    public Alarm findAlarm(@PathVariable String id) {
		
		Alarm alarm =  service.findById(id);
		
        return alarm;
    }			
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAlarmNotFound(AlarmNotFoundException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
		return ex.getMessage();
    }
	
	@ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleClientErrors(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ex.getMessage();
    }
 
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ex.getMessage();
    }	
}

package net.kraklups.photonwell.controller;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.photonwell.model.alarm.Alarm;
import net.kraklups.photonwell.model.alarmservice.AlarmService;
import net.kraklups.photonwell.util.AlarmNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	@RequestMapping(value = "/addalarm", method = RequestMethod.POST)
	public @ResponseBody Alarm create(@RequestBody @Valid Alarm alarm) {
		return service.create(alarm);
	}
	
	@RequestMapping(value = "/getalarms", method = RequestMethod.GET)
    public List<Alarm> findAll() {
        return service.findAll();
    }		
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleDataValueNotFound(AlarmNotFoundException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}

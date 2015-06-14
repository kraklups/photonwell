package net.kraklups.photonwell.controller;

import java.util.List;

import javax.validation.Valid;

import net.kraklups.photonwell.model.eventtsk.EventTsk;
import net.kraklups.photonwell.model.eventtskservice.EventTskService;
import net.kraklups.photonwell.util.EventTskNotFoundException;

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
final class EventTskController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventTskController.class);
	
	@Autowired
	private final EventTskService service;
	
	@Autowired
	public EventTskController(EventTskService service) {
		this.service = service;
	}

	@RequestMapping(value = "/registereventtsk", method = RequestMethod.POST)
	public @ResponseBody EventTsk create(@RequestBody @Valid EventTsk eventTsk) {
		return service.create(eventTsk);
	}
	
	@RequestMapping(value = "/geteventtsks", method = RequestMethod.GET)
    public List<EventTsk> findAll() {
        return service.findAll();
    }		

	@RequestMapping(value = "/geteventtsk/{eventTskId}", method = RequestMethod.GET)
    public @ResponseBody EventTsk findEventTsk(@PathVariable String eventTskId) {
		
		EventTsk eventTsk =  service.findById(eventTskId);
		
        return eventTsk;
    }			
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEventTskNotFound(EventTskNotFoundException ex) {
		LOGGER.error("Handling error with message: {}", ex.getMessage());
    }
}

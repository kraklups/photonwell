package net.kraklups.photonwell.util;

public class EventTskNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7297943393841002843L;

	public EventTskNotFoundException(String eventTskId) {
		super(String.format("No EventTsk entry found with id: <%s>", eventTskId));
	}

}
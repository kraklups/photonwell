package net.kraklups.photonwell.util;

public class AlarmNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1879095128317849054L;

	public AlarmNotFoundException(String id) {
		super(String.format("No todo entry found with id: <%s>", id));
	}

}

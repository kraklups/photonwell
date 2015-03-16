package net.kraklups.photonwell.util;

public class DataValueNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1879095128317849054L;

	public DataValueNotFoundException(String id) {
		super(String.format("No todo entry found with id: <%s>", id));
	}

}

package exceptions;

@SuppressWarnings("serial")
public class EntityNotFoundException extends Exception {

	public EntityNotFoundException() {

	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public EntityNotFoundException(String message) {
		super(message);

	}

}
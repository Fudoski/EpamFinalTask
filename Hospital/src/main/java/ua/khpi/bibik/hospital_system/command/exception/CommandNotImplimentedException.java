package ua.khpi.bibik.hospital_system.command.exception;

public class CommandNotImplimentedException extends CommandException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandNotImplimentedException() {
		super();
	}

	public CommandNotImplimentedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommandNotImplimentedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandNotImplimentedException(String message) {
		super(message);
	}

	public CommandNotImplimentedException(Throwable cause) {
		super(cause);
	}
	
	

	
}

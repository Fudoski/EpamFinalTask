package ua.khpi.bibik.hospital_system.command.exception;

public class CommandNotInitializedException extends CommandException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommandNotInitializedException() {
		super();
	}

	public CommandNotInitializedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommandNotInitializedException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommandNotInitializedException(String message) {
		super(message);
	}

	public CommandNotInitializedException(Throwable cause) {
		super(cause);
	}

}

package bridge.handler.exception;

public class ExceptionHandler {

	public static void raisingException(String message) {
		throw new IllegalArgumentException(message);
	}

}

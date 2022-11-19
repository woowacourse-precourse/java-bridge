package bridge.validator;

public class RetryValidator {
	public static void validateRetryCommand(String retryCommand) {
		if (!(retryCommand.equals("R") || retryCommand.equals("Q"))) {
			throw new IllegalArgumentException(ErrorConstants.ERROR_NOT_R_OR_Q);
		}
	}
}

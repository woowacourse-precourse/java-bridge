package domain;

public class Validate {
	private String errorMessage;

	public void validateSize(String size) {
		if (size.charAt(0) - 48 < 3 || 20 < size.charAt(0) - 48) {
			errorMessage = ErrorMessage.WRONG_SIZE.getErrorMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void validateMove(String move) {
		if (!move.equals("U") && !move.equals("D")) {
			errorMessage = ErrorMessage.WRONG_MOVING.getErrorMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}

	public void validateGameCommand(String gameCommand) {
		if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
			errorMessage = ErrorMessage.WRONG_COMMAND.getErrorMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}
}

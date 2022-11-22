package bridge.validation;

import bridge.gameInput.GameCommand;
import bridge.gameInput.PlayerMove;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Validation {
	private static final int MIN_BRIDGE_SIZE = 3;
	private static final int MAX_BRIDGE_SIZE = 20;
	private static String bridgeSize;
	private static String movingDirection;
	private static String gameCommand;
	private static InputView inputView = new InputView();
	private static OutputView outputView = new OutputView();

	public static int validateBridgeSize(int length) {
		do {
			bridgeSize = inputView.readBridgeSize();
		} while (isBridgeSizeException(length));

		return Integer.parseInt(bridgeSize);
	}

	private static boolean isBridgeSizeException(int length) {
		try {
			validateLength(bridgeSize, length);
			validateNumberOnly(bridgeSize);
			validateRange(bridgeSize);
		} catch (IllegalArgumentException exception) {
			outputView.printExceptionMessage(exception);
			return true;
		}
		return false;
	}

	public static void validateRange(String bridgeSize) {
		if (isRangeException(Integer.parseInt(bridgeSize))) {
			throw Exceptions.LENGTH_EXCEPTION.getException();
		}
	}

	private static boolean isRangeException(int bridgeSize) {
		return (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE);
	}

	public static void validateLength(String input, int length) {
		if (input.length() > length) {
			throw Exceptions.LENGTH_EXCEPTION.getException();
		}
	}

	public static void validateNumberOnly(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException exception) {
			throw Exceptions.NUMBER_ONLY_EXCEPTION.getException();
		}
	}

	public static String validateMoving(int length) {
		do {
			movingDirection = inputView.readMoving();
		} while (isMovingException(length));

		return movingDirection;
	}

	private static boolean isMovingException(int length) {
		try {
			validateLength(movingDirection, length);
			validateUOrD(movingDirection);
		} catch (IllegalArgumentException exception) {
			outputView.printExceptionMessage(exception);
			return true;
		}
		return false;
	}

	public static void validateUOrD(String movingDirection) {
		if (isUOrDException(movingDirection)) {
			throw Exceptions.U_OR_D_EXCEPTION.getException();
		}
	}

	private static boolean isUOrDException(String movingDirection) {
		return !movingDirection.equals(PlayerMove.UP.getDirection()) &&
			!movingDirection.equals(PlayerMove.DOWN.getDirection());
	}

	public static String validateGameCommand(int length) {
		do {
			gameCommand = inputView.readGameCommand();
		} while (isGameCommandException(length));

		return gameCommand;
	}

	private static boolean isGameCommandException(int length) {
		try {
			validateLength(gameCommand, length);
			validateROrQ(gameCommand);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}

	public static void validateROrQ(String gameCommand) {
		if (isROrQException(gameCommand)) {
			throw Exceptions.R_OR_Q_EXCEPTION.getException();
		}
	}

	private static boolean isROrQException(String gameCommand) {
		return !gameCommand.equals(GameCommand.RE_START.getCommand()) &&
			!gameCommand.equals(GameCommand.QUIT.getCommand());
	}
}

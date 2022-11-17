package bridge.validation;

import bridge.gameInput.GameCommand;
import bridge.gameInput.PlayerMove;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Validation {
	private static final int MIN_BRIDGE_SIZE = 3;
	private static final int MAX_BRIDGE_SIZE = 20;
	private static InputView inputView = new InputView();
	private static OutputView outputView = new OutputView();

	public static int validateBridgeSize(int length) {
		String input;

		do {
			input = inputView.readBridgeSize();
		} while (isBridgeSizeException(length, input));

		return Integer.parseInt(input);
	}

	private static boolean isBridgeSizeException(int length, String input) {
		try {
			validateLength(input, length);
			validateNumberOnly(input);
			validateRange(input);
		} catch (IllegalArgumentException exception) {
			outputView.printExceptionMessage(exception);
			return true;
		}
		return false;
	}

	public static void validateRange(String input) {
		int bridgeSize = Integer.parseInt(input);

		if (isRangeException(bridgeSize)) {
			throw Exceptions.LENGTH_EXCEPTION.getException();
		}
	}

	private static boolean isRangeException(int bridgeSize) {
		return bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE;
	}

	public static void validateLength(String input, int length) {
		if (input.length() > length) {
			throw Exceptions.LENGTH_EXCEPTION.getException();
		}
	}

	public static void validateNumberOnly(String input) {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw Exceptions.NUMBER_ONLY_EXCEPTION.getException();
		}
	}

	public static String validateMoving(int length) {
		String input;

		do {
			input = inputView.readMoving();
		} while (isMovingException(input, length));

		return input;
	}

	private static boolean isMovingException(String input, int length) {
		try {
			validateLength(input, length);
			validateUOrD(input);
		} catch (IllegalArgumentException exception) {
			outputView.printExceptionMessage(exception);
			return true;
		}
		return false;
	}

	private static void validateUOrD(String input) {
		if (isUOrDException(input)) {
			throw Exceptions.U_OR_D_EXCEPTION.getException();
		}
	}

	private static boolean isUOrDException(String input) {
		return !input.equals(PlayerMove.UP.getDirection()) &&
			!input.equals(PlayerMove.DOWN.getDirection());
	}

	public static String validateGameCommand(int length) {
		String input;

		do {
			input = inputView.readGameCommand();
		} while (isGameCommandException(input, length));

		return input;
	}

	private static boolean isGameCommandException(String input, int length) {
		try {
			validateLength(input, length);
			validateROrQ(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}

	public static void validateROrQ(String input) {
		if (isROrQException(input)) {
			throw Exceptions.R_OR_Q_EXCEPTION.getException();
		}
	}

	private static boolean isROrQException(String input) {
		return !input.equals(GameCommand.RE_START.getCommand()) &&
			!input.equals(GameCommand.QUIT.getCommand());
	}
}

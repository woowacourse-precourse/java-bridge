package bridge.Validation;

import bridge.View.GuideMessageView;
import bridge.View.InputView;

public class Validation {
	public static InputView inputView = new InputView();

	public static int validateBridgeSize(int length) {
		boolean isReInput;
		String input = "";

		do {
			GuideMessageView.BRIDGE_LENGTH_GUIDE_MESSAGE.printMessage();
			input = inputView.readBridgeSize();
			isReInput = isBridgeSizeException(length, input);

		} while (isReInput);

		return Integer.parseInt(input);
	}

	private static boolean isBridgeSizeException(int length, String input) {
		try {
			validateNumberLength(input, length);
			validateNumberOnly(input);
			validateRange(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}

	public static void validateRange(String input) {
		int bridgeSize = Integer.parseInt(input);

		if (bridgeSize < 3 || bridgeSize > 20) {
			throw Exceptions.LENGTH_EXCEPTION.getException();
		}
	}

	public static void validateNumberLength(String input, int length) {
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
		boolean isReInput;
		String input = "";

		do {
			GuideMessageView.SELECT_MOVE_GUIDE_MESSAGE.printMessage();
			input = inputView.readMoving();
			isReInput = isMovingException(input, length);

		} while (isReInput);

		return input;
	}

	private static boolean isMovingException(String input, int length) {

		try {
			validateNumberLength(input, length);
			validateUOrDOnly(input);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			return true;
		}
		return false;
	}

	private static void validateUOrDOnly(String input) {
		if (!input.equals("U") && !input.equals("D")) {
			throw Exceptions.U_OR_D_ONLY_EXCEPTION.getException();
		}
	}
}

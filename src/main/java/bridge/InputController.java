package bridge;

import bridge.validator.BridgeLengthValidate;
import bridge.validator.CommandValidate;

public class InputController {
	public static int getBridgeSize() {
		try {
			String userInput = InputView.readBridgeSize();
			checkBridgeSize(userInput);
			return parseBridgeSize(userInput);
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getBridgeSize();
		}
	}

	private static int parseBridgeSize(String userInput) {
		return Integer.parseInt(userInput);
	}

	private static void checkBridgeSize(String userInput) {
		BridgeLengthValidate.validateNumber(userInput);
		BridgeLengthValidate.validateRange(userInput);
	}

	public static String getMoving() {
		try {
			String userInput = InputView.readMoving();
			checkMoving(userInput);
			return userInput;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getMoving();
		}
	}

	private static void checkMoving(String userInput) {
		CommandValidate.validateCharacter(userInput);
		CommandValidate.validateEnglish(userInput);
		CommandValidate.validateUpperCase(userInput);
		CommandValidate.validateExactCharacterUD(userInput);
	}

	public static String getGameCommand() {
		try {
			String userInput = InputView.readGameCommand();
			checkGameCommand(userInput);
			return userInput;
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			System.out.println(e.getMessage());
			return getGameCommand();
		}
	}

	private static void checkGameCommand(String userInput) {
		CommandValidate.validateCharacter(userInput);
		CommandValidate.validateEnglish(userInput);
		CommandValidate.validateUpperCase(userInput);
		CommandValidate.validateExactCharacterRQ(userInput);
	}
}

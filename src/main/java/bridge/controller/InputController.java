package bridge.controller;

import bridge.validator.BridgeLengthValidate;
import bridge.validator.CommandValidate;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
	public static int getBridgeSize() {
		try {
			return inputBridgeSize();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getBridgeSize();
		}
	}

	private static int inputBridgeSize() {
		String userInput = InputView.readBridgeSize();
		checkBridgeSize(userInput);
		return parseBridgeSize(userInput);
	}

	private static void checkBridgeSize(String userInput) {
		BridgeLengthValidate.validateNumber(userInput);
		BridgeLengthValidate.validateRange(userInput);
	}

	private static int parseBridgeSize(String userInput) {
		return Integer.parseInt(userInput);
	}

	public static String getMoving() {
		try {
			return inputMoving();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getMoving();
		}
	}

	private static String inputMoving() {
		String userInput = InputView.readMoving();
		checkMoving(userInput);
		return userInput;
	}

	private static void checkMoving(String userInput) {
		CommandValidate.validateCharacter(userInput);
		CommandValidate.validateEnglish(userInput);
		CommandValidate.validateUpperCase(userInput);
		CommandValidate.validateExactCharacterUD(userInput);
	}

	public static String getGameCommand() {
		try {
			return inputGameCommand();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			return getGameCommand();
		}
	}

	private static String inputGameCommand() {
		String userInput = InputView.readGameCommand();
		checkGameCommand(userInput);
		return userInput;
	}

	private static void checkGameCommand(String userInput) {
		CommandValidate.validateCharacter(userInput);
		CommandValidate.validateEnglish(userInput);
		CommandValidate.validateUpperCase(userInput);
		CommandValidate.validateExactCharacterRQ(userInput);
	}
}

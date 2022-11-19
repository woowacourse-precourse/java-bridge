package bridge.handler.check;

import bridge.handler.exception.ExceptionHandler;
import bridge.view.Message;

public class CheckHandler {

	public static String isBridgeLengthInput(String input) {
		isNumber(input);
		isValidNumber(input);
		return input;
	}

	public static String isMoveInput(String input) {
		isMoveCommand(input);
		return input;
	}

	public static String isGameCommandInput(String input) {
		isGameCommand(input);
		return input;
	}

	private static void isNumber(String input) {
		if (!input.matches("^[0-9]+$")) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getErrorMessage(Message.INPUT_NOT_NUMBER));
		}
	}

	private static void isValidNumber(String input) {
		int inputNumber = Integer.parseInt(input);
		if (isOutOfRange(inputNumber)) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getErrorMessage(Message.INPUT_OUT_OF_RANGE));
		}
	}

	private static boolean isOutOfRange(int inputNumber) {
		return inputNumber < 3 || inputNumber > 20;
	}

	private static void isMoveCommand(String inputMoveCommand) {
		if (isCommand(inputMoveCommand, "U", "D")) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getErrorMessage(Message.INPUT_NOT_MOVE_COMMAND));
		}
	}

	private static void isGameCommand(String inputMoveCommand) {
		if (isCommand(inputMoveCommand, "R", "Q")) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getErrorMessage(Message.INPUT_NOT_GAME_COMMAND));
		}
	}

	private static boolean isCommand(String inputCommand, String command1, String command2) {
		return !(inputCommand.equals(command1) || !inputCommand.equals(command2));
	}

}

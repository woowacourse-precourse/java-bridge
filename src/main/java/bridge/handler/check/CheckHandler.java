package bridge.handler.check;

import bridge.handler.exception.ExceptionHandler;
import bridge.view.Message;

public class CheckHandler {

	public static String isBridgeLengthInput(String input) {
		//TODO : 다리 길이 입력시 예외처리 구현 중
		isNumber(input);
		isValidNumber(input);
		return input;
	}

	public static String isMoveInput(String input) {
		//TODO : 이동 위치 입력시 예외처리 구현 중
		isMoveCommand();
		return input;
	}

	public static String isGameCommandInput(String input) {
		//TODO : 게임 종료 여부 입력 시 예외처리 구현 중
		isGameCommand();
		return input;
	}

	private static void isNumber(String input) {
		if (!input.matches("^[0-9]+$")) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getMessage(Message.INPUT_NOT_NUMBER));
		}
	}

	private static void isValidNumber(String input) {
		int inputNumber = Integer.parseInt(input);
		if (isOutOfRange(inputNumber)) {
			ExceptionHandler.raisingIllegalArgumentException(Message.getMessage(Message.INPUT_OUT_OF_RANGE));
		}
	}

	private static boolean isOutOfRange(int inputNumber) {
		return inputNumber < 3 || inputNumber > 20;
	}

	private static void isMoveCommand() {
		//TODO : 이동 명령어 입력이 U/D 가 아니면 예외 발생
	}

	private static void isGameCommand() {
		//TODO : 게임 명령어 입력이 R/Q 가 아니면 예외 발생
	}

}

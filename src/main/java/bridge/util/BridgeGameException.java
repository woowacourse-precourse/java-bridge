package bridge.util;

public class BridgeGameException {

	public static final String ERROR_MESSAGE_TRIM = "[ERROR] 입력에 공백이 들어가면 안됩니다.";
	public static final String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 입력 값이 숫자가 아닙니다.";
	public static final String ERROR_MESSAGE_SIZE_BOUNDARY = "[ERROR] 허용된 블록 사이즈가 아닙니다.";
	public static final String ERROR_MESSAGE_ORDER_NOT_MOVE = "[ERROR] 허용된 이동 명령이 아닙니다.";
	public static final String ERROR_MESSAGE_ORDER_NOT_CONTROL = "[ERROR] 허용된 제어 명령이 아닙니다.";


	public static void illegalArgumentException(String message) {
		throw new IllegalArgumentException(message);
	}
}

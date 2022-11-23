package bridge.common.exception;

import static bridge.common.exception.ErrorMessageConstant.*;

public class ErrorMessage {
	public static final String HEADER = "[ERROR] ";
	public static final String NULL_OR_EMPTY_EXCEPTION_MESSAGE = "입력 값은 Null 또는 Empty 일 수 없습니다.";
	public static final String NON_NUMERIC_EXCEPTION_MESSAGE = "입력 값은 숫자만 가능합니다.";
	public static final String NOT_RESTART_OR_QUIT_EXCEPTION_MESSAGE = "게임 재시작 명령어(R)과 게임 종료 명령어(Q)만 입력 가능합니다.";
	public static final String INVALID_BRIDGE_LENGTH_EXCEPTION_MESSAGE =
		"다리의 길이는 " + MIN_BRIDGE_SIZE + " 이상 " + MAX_BRIDGE_SIZE + " 이하의 숫자만 가능합니다.";
	public static final String NOT_UP_OR_DOWN_EXCEPTION_MESSAGE = "이동할 칸은 U 또는 D 만 입력 가능합니다.";

}

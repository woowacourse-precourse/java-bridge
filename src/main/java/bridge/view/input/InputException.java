package bridge.view.input;

import bridge.view.output.OutputView;

public class InputException extends IllegalArgumentException {

	public static final String EMPTY = "[ERROR] 입력 값이 없습니다.";
	public static final String NOT_A_NUMBER = "[ERROR] 자연수만 입력해주세요.";
	public static final String NOT_IN_BETWEEN_PROPER_RANGE = "[ERROR] 숫자는 %d 이상 %d 이하의 자연수 값이어야 합니다.";

	public static final String MOVEMENT_NOT_ASSIGNED_COMMAND = "[ERROR] 이동 선택시 U 혹은 D 둘 중에 하나를 선택해야 합니다.";
	public static final String GAME_COMMAND_NOT_ASSIGNED_COMMAND = "[ERROR] 재시도 및 종료 선택시 R 혹은 Q 둘 중에 하나를 선택해야 합니다.";

	public InputException(String message) {
		super(message);
		OutputView.withContentOf(message, false, false).ConsoleMessage();
	}
}

package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	public static final String UP = "U";
	private static final String DOWN = "D";
	public static final String RETRY = "R";
	private static final String QUIT = "Q";

	private static final String NULL = "";
	private static final String ERROR_READ_GAME_COMMAND = "R or Q를 입력하세요";
	private static final String ERROR_READ_MOVING = "U or D를 입력하세요";
	private static final String ERROR_NULL = "입력이 없습니다";
	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		return Integer.parseInt(validateNull(Console.readLine()));
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		return validateReadMoving(Console.readLine());
	}

	private String validateReadMoving(String moveInput) {
		if (moveInput.equals(UP) || moveInput.equals(DOWN)) {
			throw new IllegalArgumentException(ERROR_READ_MOVING);
		}
		return validateNull(moveInput);
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return validateGameCommand(Console.readLine());
	}

	private String validateGameCommand(String gameCommand) {
		if (!(gameCommand.equals(RETRY) || gameCommand.equals(QUIT))) {
			throw new IllegalArgumentException(ERROR_READ_GAME_COMMAND);
		}
		return validateNull(gameCommand);
	}

	private String validateNull(String input) {
		if (input.equals(NULL)) {
			throw new NullPointerException(ERROR_NULL);
		}
		return input;
	}
}

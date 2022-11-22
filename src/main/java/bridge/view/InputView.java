package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private static final String ERROR_MESSAGE = "[ERROR]";
	private static final String BRIDGESIZE_ERROR_MESSAGE = " 다리 길이는 3부터 20사이의 숫자여야 합니다.";
	private static final String MOVING_ERROR_MESSAGE = " 이동할 칸은 U 또는 D 중 하나의 문자를 입력해야 합니다.";
	private static final String GAME_COMMAND_ERROR_MESSAGE = " 게임 재시작/종료는 R과 Q 중 하나의 문자를 입력해야 합니다.";
	private OutputView outputView = new OutputView();

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		String readBridgeSize = Console.readLine();
		validateBridgeSize(readBridgeSize);
		int bridgeSize = Integer.parseInt(readBridgeSize);
		return bridgeSize;
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		String moving = Console.readLine();
		validateMoving(moving);
		return moving;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		String gameCommand = Console.readLine();
		validateGameCommand(gameCommand);
		return gameCommand;
	}

	private void validateBridgeSize(String input) {

	}

	private void validateMoving(String input) {

	}

	private void validateGameCommand(String input) {

	}
}

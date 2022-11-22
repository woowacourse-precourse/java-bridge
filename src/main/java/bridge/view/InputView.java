package bridge.view;

import static bridge.message.InputMessageConstants.*;
import static bridge.message.MessageConstants.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public String readBridgeSize() {
		System.out.print(BRIDGE_SIZE_MESSAGE);
		return readUserInput();
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.printf(GAME_COMMAND_MESSAGE_FORMAT, UP_COMMAND_MESSAGE, DOWN_COMMAND_MESSAGE);
		return readUserInput();
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.printf(RESTART_OR_EXIT_MESSAGE_FORMAT, RESTART_COMMAND_MESSAGE, EXIT_COMMAND_MESSAGE);
		return readUserInput();
	}

	public String readUserInput() {
		return Console.readLine();
	}
}

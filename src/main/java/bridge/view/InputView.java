package bridge.view;

import bridge.handler.check.CheckHandler;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	public static final String GAME_START = "다리 건너기 게임을 시작합니다.";

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		Message.printMessage(Message.INPUT_BRIDGE_LENGTH);
		return Integer.parseInt(CheckHandler.isBridgeLengthInput(Console.readLine()));
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		Message.printMessage(Message.INPUT_MOVE_COMMAND);
		return CheckHandler.isMoveInput(Console.readLine());
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		Message.printMessage(Message.INPUT_GAME_COMMAND);
		return CheckHandler.isGameCommandInput(Console.readLine());
	}

}

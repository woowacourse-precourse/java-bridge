package bridge.view;

import bridge.handler.check.CheckHandler;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		String input = Console.readLine();
		CheckHandler.isBridgeLengthInput(input); // TODO : 다리 길이 입력시 정상 입력되었는지 확인
		return Integer.parseInt(input);
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		String input = Console.readLine();
		CheckHandler.isMoveInput(input);
		return input;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return null;
	}
}

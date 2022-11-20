package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	/**
	 * 다리의 길이를 입력받는다.
	 */
	public String readBridgeSize() {
		System.out.println(InputMessages.BRIDGE_LENGTH_REQUEST);
		return Console.readLine();
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println(InputMessages.MOVE_REQUEST);
		return Console.readLine();
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(InputMessages.QUIT_OR_RETRY);
		return Console.readLine();
	}
}

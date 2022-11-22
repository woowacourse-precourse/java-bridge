package bridge.view;

import static bridge.util.Message.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public static String readBridgeSize() {
		System.out.println(INPUT_BRIDGE_LENGTH);
		return Console.readLine();
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public static String readMoving() {
		System.out.println(INPUT_DIRECTION);
		return Console.readLine();
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public static String readGameCommand() {
		System.out.println(INPUT_RESTART_OR_QUIT);
		return Console.readLine();
	}
}

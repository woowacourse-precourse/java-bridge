package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	public static String BRIDGE_SIZE_PHRASE = "다리의 길이를 입력해주세요.";
	public static String CHOOSE_MOVE_SPACE_PHRASE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public static String RESTART_OR_QUIT_PHRASE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public String readBridgeSize() {
		System.out.println(BRIDGE_SIZE_PHRASE);
		return Console.readLine();
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println(CHOOSE_MOVE_SPACE_PHRASE);
		return Console.readLine();
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(RESTART_OR_QUIT_PHRASE);
		return Console.readLine();
	}
}

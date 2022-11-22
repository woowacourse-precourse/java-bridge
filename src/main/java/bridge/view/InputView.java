package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static final String BRIDGE_SIZE_PHRASE = "다리의 길이를 입력해주세요.";
	public static final String CHOOSE_MOVE_SPACE_PHRASE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public static final String RESTART_OR_QUIT_PHRASE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	public String readBridgeSize() {
		System.out.println(BRIDGE_SIZE_PHRASE);
		return Console.readLine();
	}

	public String readMoving() {
		System.out.println(CHOOSE_MOVE_SPACE_PHRASE);
		return Console.readLine();
	}

	public String readGameCommand() {
		System.out.println(RESTART_OR_QUIT_PHRASE);
		return Console.readLine();
	}
}

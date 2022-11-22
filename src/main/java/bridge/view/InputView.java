package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.\n";
	private final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해 주세요.";
	private final String SELECT_THE_DIRECTION_YOU_WANT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private final String INPUT_COMMAND_WHETHER_GAME_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	
	public void startGame() {
		System.out.println(START_BRIDGE_GAME);
	}

	public String readBridgeSize() {
		System.out.println(INPUT_BRIDGE_LENGTH);
		return Console.readLine();
	}

	public String readMoving() {
		System.out.println(SELECT_THE_DIRECTION_YOU_WANT);
		return Console.readLine();
	}

	public String readGameCommand() {
		System.out.println(INPUT_COMMAND_WHETHER_GAME_RETRY_OR_QUIT);
		return Console.readLine();
	}
}

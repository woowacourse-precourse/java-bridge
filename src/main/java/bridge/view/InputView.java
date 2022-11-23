package bridge.view;

import bridge.domain.rule.BridgeRule;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	private static final String ENTER = System.lineSeparator();
	private static final String PRINT_GAME_START = "다리 건너기 게임을 시작합니다.";
	private static final String PRINT_SIZE_SELECT = ENTER + "다리의 길이를 입력해주세요.";
	private static final String MOVE_SELECT = ENTER + "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String GAME_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	private BridgeRule bridgeRule;

	public InputView() {
		this.bridgeRule = new BridgeRule();
	}

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		System.out.println(PRINT_SIZE_SELECT);
		String size = Console.readLine();
		int number = bridgeRule.isNumber(size);
		bridgeRule.isInRange(number);
		return number;
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println(MOVE_SELECT);
		String command = Console.readLine();
		bridgeRule.isMoveCommand(command);
		return command;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(GAME_RETRY);
		String command = Console.readLine();
		bridgeRule.isRetryCommand(command);
		return command;
	}
}

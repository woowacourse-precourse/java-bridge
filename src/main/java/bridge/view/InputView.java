package bridge.view;

import bridge.GameRule;
import bridge.validator.BridgeBoardValidator;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
	private static final String INPUT_MOVING =
		"이동할 칸을 선택해주세요. (위: " + GameRule.UP_BOARD + ", 아래: " + GameRule.DOWN_BOARD + ")";
	private static final String INPUT_COMMAND =
		"게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + GameRule.RETRY_COMMAND + ", 종료: " + GameRule.QUIT_COMMAND + ")";

	public int readBridgeSize() {
		System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);

		try {
			return Integer.parseInt(BridgeSizeValidator.validate(Console.readLine()));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readBridgeSize();
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
        System.out.println(INPUT_MOVING);

        try {
			return BridgeBoardValidator.validate(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(INPUT_COMMAND);
		try {
			return GameCommandValidator.validate(Console.readLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readGameCommand();
		}
	}


}

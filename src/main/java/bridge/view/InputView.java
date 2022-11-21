package bridge.view;

import static camp.nextstep.edu.missionutils.Console.*;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.UserInputValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	static UserInputValidator userInputValidator = new UserInputValidator();

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public static int readBridgeSize() throws IllegalArgumentException {
		BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
		return bridgeSizeValidator.runBridgeSizeValidator(readLine());
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public static String readMoving() throws IllegalArgumentException {
		return userInputValidator.runMoveInputValidator(readLine());
		// return readLine();
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return userInputValidator.runDecisionValidator(readLine());
		// return null;
	}
}

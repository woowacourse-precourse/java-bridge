package bridge.view;

import static camp.nextstep.edu.missionutils.Console.*;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingValidator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public static int readBridgeSize() {
		final String inputBridgeSize = getUserInput();
		BridgeSizeValidator.validate(inputBridgeSize);

		return Integer.parseInt(inputBridgeSize);
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public static String readMoving() {
		final String inputMoving = getUserInput();
		MovingValidator.validate(inputMoving);

		return inputMoving;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public static String readGameCommand() {
		String inputGameCommand = getUserInput();
		GameCommandValidator.validate(inputGameCommand);
		return inputGameCommand;
	}

	private static String getUserInput() {
		return readLine();
	}
}

package bridge;

import static camp.nextstep.edu.missionutils.Console.*;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.UserInputValidator;

public class InputView {
	static UserInputValidator userInputValidator = new UserInputValidator();

	public static int readBridgeSize() throws IllegalArgumentException {
		BridgeSizeValidator bridgeSizeValidator = new BridgeSizeValidator();
		return bridgeSizeValidator.runBridgeSizeValidator(readLine());
	}

	public static String readMoving() throws IllegalArgumentException {
		return userInputValidator.runMoveInputValidator(readLine());
	}

	public static String readGameCommand() throws IllegalArgumentException {
		return userInputValidator.runDecisionValidator(readLine());
	}
}

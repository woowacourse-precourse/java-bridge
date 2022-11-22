package bridge.view;

import static camp.nextstep.edu.missionutils.Console.*;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingValidator;

public class InputView {

	public static int readBridgeSize() {
		final String inputBridgeSize = getUserInput();
		BridgeSizeValidator.validate(inputBridgeSize);

		return Integer.parseInt(inputBridgeSize);
	}

	public static String readMoving() {
		final String inputMoving = getUserInput();
		MovingValidator.validate(inputMoving);

		return inputMoving;
	}

	public static String readGameCommand() {
		String inputGameCommand = getUserInput();
		GameCommandValidator.validate(inputGameCommand);
		return inputGameCommand;
	}

	private static String getUserInput() {
		return readLine();
	}
}

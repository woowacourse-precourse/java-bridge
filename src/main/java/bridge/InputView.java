package bridge;

import bridge.utils.BoilerPlates;
import bridge.utils.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public static int readBridgeSize() {
		BoilerPlates.readBridgeSize();
		String bridgeSize = Console.readLine();
		Validator.validateBridgeSize(bridgeSize);
		return Integer.parseInt(bridgeSize);
	}

	public static String readMoving() {
		BoilerPlates.readMoving();
		String moving = Console.readLine();
		Validator.validateMoving(moving);
		return moving;
	}

	public static String readGameCommand() {
		BoilerPlates.readGameCommand();
		String isRestart = Console.readLine();
		Validator.validateIsRestart(isRestart);
		return isRestart;
	}
}

package bridge;

import bridge.enums.Command;
import bridge.enums.Error;
import bridge.enums.InputPattern;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

	public int readBridgeSize() {
		return validateBridgeSize(Console.readLine());
	}

	public int validateBridgeSize(String userInput) {
		if (!Pattern.matches(InputPattern.BRIDGE_SIZE.getValue(), userInput)) {
			throw new IllegalArgumentException(Error.BRIDGE_SIZE.getValue());
		}
		return Integer.parseInt(userInput);
	}

	public String readMoving() {
		return validateMove(Console.readLine());
	}

	public String validateMove(String userInput) {
		if (!Pattern.matches(InputPattern.MOVE.getValue(), userInput)) {
			throw new IllegalArgumentException(Error.MOVE.getValue());
		}
		if (userInput.equals(Command.UP.getValue())) {
			return Command.UP.getValue();
		}
		return Command.DOWN.getValue();
	}

	public String readGameCommand() {
		return validateRetry(Console.readLine());
	}

	public String validateRetry(String userInput) {
		if (userInput.equals(Command.RESTART.getValue())) {
			return Command.RESTART.getValue();
		}
		if (userInput.equals(Command.QUIT.getValue())) {
			return Command.QUIT.getValue();
		}
		throw new IllegalArgumentException(Error.RETRY.getValue());
	}
}

package bridge.filter;

import static bridge.message.ErrorMessageConstants.*;
import static bridge.message.MessageConstants.*;
import static bridge.restrict.RestrictConstants.*;

public class UserInputFilter {

	public int bindingBridgeSize(String userInput) {
		int result = 0;
		checkUserInput(userInput);
		for (int userInputIndex = 0; userInputIndex < userInput.length(); userInputIndex++) {
			result *= 10;
			result += userInput.charAt(userInputIndex) - '0';
		}
		checkBindingBridgeSize(result);
		return result;
	}

	public String bindingMoveCommand(String userInput) {
		checkUserInput(userInput);
		checkCommand(userInput);
		return userInput;
	}

	public String bindingRestartOrExitCommand(String userInput) {
		checkUserInput(userInput);
		checkRestartOrExitCommand(userInput);
		return userInput;
	}

	private void checkBindingBridgeSize(int bindingBridgeSize) {
		if (bindingBridgeSize < MIN_NUMBER || MAX_NUMBER < bindingBridgeSize) {
			throw new IllegalArgumentException(String.format(RANGE_ERROR_MESSAGE_FORMAT, MIN_NUMBER, MAX_NUMBER));
		}
	}

	private void checkUserInput(String userInput) {
		if (userInput == null) {
			throw new IllegalArgumentException(USER_INPUT_ERROR_MESSAGE);
		}
	}

	private void checkCommand(String command) {
		if (!(command.equals(UP_COMMAND_MESSAGE) || command.equals(DOWN_COMMAND_MESSAGE))) {
			throw new IllegalArgumentException(
				String.format(UP_OR_DOWN_COMMAND_ERROR_MESSAGE_FORMAT, UP_COMMAND_MESSAGE, DOWN_COMMAND_MESSAGE));
		}
	}

	private void checkRestartOrExitCommand(String command) {
		if (!(command.equals(RESTART_COMMAND_MESSAGE) || command.equals(EXIT_COMMAND_MESSAGE))) {
			throw new IllegalArgumentException(
				String.format(RESTART_OR_EXIT_COMMAND_ERROR_MESSAGE, RESTART_COMMAND_MESSAGE, EXIT_COMMAND_MESSAGE));
		}
	}
}

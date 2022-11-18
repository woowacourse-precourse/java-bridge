package bridge.filter;

import static bridge.message.ErrorMessageConstants.*;
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
}

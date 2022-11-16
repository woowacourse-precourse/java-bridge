package bridge.validator;

import bridge.Error;

public class BridgeSize {
	private final int bridgeSize;

	public BridgeSize(String inputValue) {
		int value = convertToInt(inputValue);
		validateRange(value);
		this.bridgeSize = value;
	}

	public int getSize() {
		return bridgeSize;
	}

	private int convertToInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(Error.FORMAT.getMessage());
		}
	}

	private void validateRange(int value) {
		if (!isInRange(value)) {
			throw new IllegalArgumentException(Error.RANGE.getMessage());
		}
	}

	private static boolean isInRange(int value) {
		return 3 <= value && value <= 20;
	}
}

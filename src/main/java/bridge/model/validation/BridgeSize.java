package bridge.model.validation;

import bridge.model.constant.Error;

public class BridgeSize {
	public static final int MIN_NUMBER = 3;
	public static final int MAX_NUMBER = 20;
	private final int bridgeSize;

	public BridgeSize(int value) {
		validateRange(value);
		this.bridgeSize = value;
	}

	public int getSize() {
		return bridgeSize;
	}

	private void validateRange(int value) {
		if (!isInRange(value)) {
			throw new IllegalArgumentException(Error.RANGE.getMessage());
		}
	}

	private static boolean isInRange(int value) {
		return MIN_NUMBER <= value && value <= MAX_NUMBER;
	}
}

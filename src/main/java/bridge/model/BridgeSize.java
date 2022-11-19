package bridge.model;

import bridge.Error;

public class BridgeSize {
	private static final int MIN_NUMBER = 3;
	private static final int MAX_NUMBER = 20;

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

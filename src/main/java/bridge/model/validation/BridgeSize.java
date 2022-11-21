package bridge.model.validation;

import bridge.model.constant.Error;

public enum BridgeSize {
	MIN(3),
	MAX(20),
	;

	private final int bridgeSize;

	BridgeSize(int bridgeSize) {
		this.bridgeSize = bridgeSize;
	}

	public int getSize() {
		return bridgeSize;
	}

	public static int validateRange(int size) {
		if (!isInRange(size)) {
			throw new IllegalArgumentException(Error.RANGE.getMessage());
		}
		return size;
	}

	private static boolean isInRange(int size) {
		return MIN.bridgeSize <= size && size <= MAX.bridgeSize;
	}
}

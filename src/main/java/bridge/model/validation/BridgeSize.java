package bridge.model.validation;

import bridge.model.constant.Error;
import bridge.model.constant.Size;

public class BridgeSize {

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
		return Size.MIN.getNumber() <= value && value <= Size.MAX.getNumber();
	}
}

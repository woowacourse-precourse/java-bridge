package bridge.domain;

import static bridge.Constants.SIZE_MAX;
import static bridge.Constants.SIZE_MIN;

public class BridgeSize {
	private final int bridgeSize;

	public BridgeSize(String input) {
		this.bridgeSize = validateInt(input);
		validateRange();
	}

	private int validateInt(String input) {
		int bridgeSize = 0;

		try {
			bridgeSize = Integer.parseInt(input);
		} catch (NumberFormatException exception) {
			throw new IllegalArgumentException();
		}
		return bridgeSize;
	}

	private void validateRange() {
		if (bridgeSize < SIZE_MIN || SIZE_MAX < bridgeSize) {
			throw new IllegalArgumentException();
		}
	}

	public int getSize() {
		return bridgeSize;
	}
}

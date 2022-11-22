package bridge;

import util.Validator;

public class BridgeSize {
	private final int bridgeSize;

	public BridgeSize(int bridgeSize) {
		Validator.validateBridgeSizeRange(bridgeSize);
		this.bridgeSize = bridgeSize;
	}

	public int getBridgeSize() {
		return bridgeSize;
	}
}

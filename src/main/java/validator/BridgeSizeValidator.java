package validator;

import static view.InputViewConstants.ERROR_MESSAGE_NON_NUMERIC;
import static view.InputViewConstants.ERROR_MESSAGE_OUT_OF_RANGE;
import static view.InputViewConstants.MAX_BRIDGE_SIZE;
import static view.InputViewConstants.MIN_BRIDGE_SIZE;

public class BridgeSizeValidator {

	public String validateBridgeSize(String bridgeSize) {
		validateBridgeSizeNumeric(bridgeSize);
		validateBridgeSizeRange(bridgeSize);
		return bridgeSize;
	}

	private int validateBridgeSizeNumeric(String bridgeSize) {
		try {
			int validBridgeSize = Integer.parseInt(bridgeSize);
			return validBridgeSize;
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ERROR_MESSAGE_NON_NUMERIC);
		}
	}

	private void validateBridgeSizeRange(String bridgeSize) {
		int validBridgeSize = Integer.parseInt(bridgeSize);
		if (validBridgeSize < MIN_BRIDGE_SIZE || validBridgeSize > MAX_BRIDGE_SIZE) {
			throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
		}
	}
}

package bridge;

public class BridgeSize implements InputValidator {

	private final int bridgeSize;
	private static final int BRIDGE_SIZE_MIN = 3;
	private static final int BRIDGE_SIZE_MAX = 20;

	public BridgeSize(int bridgeSize) {
		validate(bridgeSize);
		this.bridgeSize = bridgeSize;
	}

	@Override
	public void validate(Object inputBridgeSize) {
		isNumberInBetween((Integer) inputBridgeSize);
	}

	public static BridgeSize valueOf(String inputBridgeSize) {
		try {
			return new BridgeSize(Integer.parseInt(inputBridgeSize));
		} catch (NumberFormatException e) {
			throw new InputException(InputException.NOT_A_NUMBER);
		}
	}

	private void isNumberInBetween(int inputBridgeLength) {
		if (inputBridgeLength < BRIDGE_SIZE_MIN || inputBridgeLength > BRIDGE_SIZE_MAX) {
			throw new InputException(String.format(InputException.NOT_IN_BETWEEN_PROPER_RANGE, BRIDGE_SIZE_MIN, BRIDGE_SIZE_MAX));
		}
	}

	public int toNumber() {
		return bridgeSize;
	}
}

package bridge;

public class BridgeSize {
	private final int bridgeSize;

	public BridgeSize(String input) {
		this.bridgeSize = validateInt(input);
		validateRange();
		// todo	예외처리
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
		if (bridgeSize < 3 || 20 < bridgeSize) {
			throw new IllegalArgumentException();
		}
	}

	public int getSize() {
		return bridgeSize;
	}
}

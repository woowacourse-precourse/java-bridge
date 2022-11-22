package bridge.domain;

import java.util.Arrays;

public enum BridgeStatus {
	FAIL(false, "X"),
	SUCCESS(true, "O");

	private final boolean bridgeStatus;
	private final String message;

	BridgeStatus(boolean bridgeStatus, String message) {
		this.bridgeStatus = bridgeStatus;
		this.message = message;
	}

	public static BridgeStatus findByBridgeStatus(boolean currentStatus) {
		return Arrays.stream(BridgeStatus.values())
			.filter(status -> status.find(currentStatus))
			.findAny()
			.orElse(FAIL);
	}

	public String getMessage() {
		return this.message;
	}
	private boolean find(boolean currentStatus) {
		return currentStatus == this.bridgeStatus;
	}
}

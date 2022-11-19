package bridge.domain;

import java.util.Arrays;

public enum BridgeStatus {
	FAIL(0, "X"),
	SUCCESS(1, "O"),
	END(2, ""),
	PASS(3, "");

	private final long bridgeStatus;
	private final String message;

	BridgeStatus(int bridgeStatus, String message) {
		this.bridgeStatus = bridgeStatus;
		this.message = message;
	}

	public static BridgeStatus findByBridgeStatus(long currentStatus) {
		return Arrays.stream(BridgeStatus.values())
			.filter(status -> status.isSuccess(currentStatus))
			.findAny()
			.orElse(END);
	}

	public String getMessage() {
		return this.message;
	}
	private boolean isSuccess(long currentStatus) {
		return currentStatus == this.bridgeStatus;
	}
}

package bridge.domain;

import java.util.Arrays;

public enum BridgeMap {

	DOWN(0, "D"),
	UP(1, "U");

	private final int upDownNumber;
	private final String upDownMessage;

	BridgeMap(int bridgeNumber, String bridgeString) {
		this.upDownNumber = bridgeNumber;
		this.upDownMessage = bridgeString;
	}

	public static String findByBridgeMapMessage(int number) {
		return Arrays.stream(values())
			.filter(bridgeMapper -> bridgeMapper.findNumber(number))
			.findAny()
			.orElse(DOWN)
			.upDownMessage;
	}

	private boolean findNumber(int number) {
		return this.upDownNumber == number;
	}
}

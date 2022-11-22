package bridge.domain;

import java.util.Arrays;

import bridge.util.GameConst;

public enum UserBridge {

	UPPER_BRIDGE(GameConst.MOVING_UP),
	LOWER_BRIDGE(GameConst.MOVING_DOWN);

	private final String location;

	UserBridge(String location) {
		this.location = location;
	}

	public static UserBridge getUserBridgeStatus(String location) {
		return Arrays.stream(UserBridge.values())
			.filter(i -> i.location.equals(location))
			.findFirst().get();
	}

	public static UserBridge getOtherUserBridgeStatus(String location) {
		return Arrays.stream(UserBridge.values())
			.filter(i -> !i.location.equals(location))
			.findFirst().get();
	}

}

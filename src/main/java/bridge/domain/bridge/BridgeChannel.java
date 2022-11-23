package bridge.domain.bridge;

import java.util.Arrays;

public enum BridgeChannel {

	DOWN(0, "D"),
	UP(1, "U");

	private final int channelType;
	private final String channelShape;

	BridgeChannel(int channelType, String channelShape) {
		this.channelType = channelType;
		this.channelShape = channelShape;
	}

	public static BridgeChannel of(int channelInNumber) {
		return Arrays.stream(BridgeChannel.values())
				.filter(channelShape -> channelShape.channelType == channelInNumber)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	public String Shape() {
		return channelShape;
	}
}

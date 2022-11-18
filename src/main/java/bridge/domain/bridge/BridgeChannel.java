package bridge.domain.bridge;

import java.util.Arrays;

public enum BridgeChannel {

	DOWN(0, "D"),
	UP(1, "U");

	private final int channelInNumber;
	private final String channelInString;

	BridgeChannel(int channelInNumber, String channelInString) {
		this.channelInNumber = channelInNumber;
		this.channelInString = channelInString;
	}

	public static BridgeChannel of(int channelInNumber) {
		return Arrays.stream(BridgeChannel.values())
				.filter(channelShape -> channelShape.channelInNumber == channelInNumber)
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public String toString() {
		return channelInString;
	}
}

package bridge.domain.bridge;

import java.util.Arrays;

public enum BridgeChannel {

	DOWN(0,"D"),
	UP(1,"U");

	private final int channelInNumber;
	private final String channelInString;

	BridgeChannel(int channelInNumber, String channelInString){
		this.channelInNumber = channelInNumber;
		this.channelInString = channelInString;
	}

	public static BridgeChannel of(int channelInNumber){
		return Arrays.stream(BridgeChannel.values())
				.filter(channelShape-> channelShape.channelInNumber == channelInNumber)	//TODO : ==처리를 다른 것으로 바꿀 수 있을지 고민
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

	@Override
	public String toString() {
		return channelInString;
	}
}

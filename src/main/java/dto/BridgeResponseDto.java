package dto;

import java.util.List;

public class BridgeResponseDto {
	private final List<String> bridge;
	private final int bridgeSize;

	public BridgeResponseDto(List<String> bridge, int bridgeSize) {
		this.bridge = bridge;
		this.bridgeSize = bridgeSize;
	}

	public List<String> getBridge() {
		return bridge;
	}

	public int getBridgeSize() {
		return bridgeSize;
	}
}

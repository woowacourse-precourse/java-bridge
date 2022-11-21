package dto;

import java.util.List;

import bridge.Bridge;

public class BridgeResponseDto {
	private final List<String> bridge;
	private final int bridgeSize;

	public BridgeResponseDto(Bridge bridge) {
		this.bridge = bridge.getBridge();
		this.bridgeSize = bridge.getBridgeSize();
	}

	public List<String> getBridge() {
		return bridge;
	}

	public int getBridgeSize() {
		return bridgeSize;
	}
}

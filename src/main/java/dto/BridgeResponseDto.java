package dto;

import java.util.List;

import bridge.Bridge;

public class BridgeResponseDto {
	private final List<String> bridge;

	public BridgeResponseDto(Bridge bridge) {
		this.bridge = bridge.getBridge();
	}

	public List<String> getBridge() {
		return bridge;
	}

}

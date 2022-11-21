package dto;

import java.util.List;

public class BridgeDto {
	private final List<String> bridge;

	public BridgeDto(List<String> bridge) {
		this.bridge = bridge;
	}

	public List<String> getBridge() {
		return bridge;
	}
}

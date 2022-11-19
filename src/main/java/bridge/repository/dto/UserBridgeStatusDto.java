package bridge.repository.dto;

import java.util.List;

public class UserBridgeStatusDto {
	private List<String> userUpperBridge;
	private List<String> userLowerBridge;
	private Integer userCurrentLocation;

	public UserBridgeStatusDto(List<String> userUpperBridge, List<String> userLowerBridge,
		Integer userCurrentLocation) {
		this.userUpperBridge = userUpperBridge;
		this.userLowerBridge = userLowerBridge;
		this.userCurrentLocation = userCurrentLocation;
	}

	public List<String> getUserUpperBridge() {
		return userUpperBridge;
	}

	public List<String> getUserLowerBridge() {
		return userLowerBridge;
	}

	public Integer getUserCurrentLocation() {
		return userCurrentLocation;
	}
}

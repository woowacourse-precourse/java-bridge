package bridge.repository;

import java.util.ArrayList;
import java.util.List;

import bridge.repository.dto.UserBridgeStatusDto;
import bridge.util.InputViewConst;
import bridge.util.OutputViewConst;

public class UserBridgeRepository {

	private List<String> userUpperBridge;
	private List<String> userLowerBridge;
	private Integer userCurrentLocation;

	public UserBridgeRepository() {
		this.userUpperBridge = new ArrayList<>();
		this.userLowerBridge = new ArrayList<>();
		this.userCurrentLocation = 0;
	}

	public void saveUserSpace(String location, String userCurrentTrace) {
		userCurrentLocation++;
		if (location.equals(InputViewConst.MOVING_UP)) {
			this.userUpperBridge.add(userCurrentTrace);
			this.userLowerBridge.add(OutputViewConst.BLANK_SPACE);
			return;
		}
		this.userUpperBridge.add(OutputViewConst.BLANK_SPACE);
		this.userLowerBridge.add(userCurrentTrace);
	}

	public UserBridgeStatusDto findUserBridgeStatusDto() {
		return new UserBridgeStatusDto(userUpperBridge, userLowerBridge, userCurrentLocation);
	}

	public void clear() {
		userUpperBridge.clear();
		userLowerBridge.clear();
		userCurrentLocation = 0;
	}
}

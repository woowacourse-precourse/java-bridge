package bridge.repository;

import java.util.ArrayList;
import java.util.List;

public class UserBridgeRepository {

	private List<String> userUpperBridge;
	private List<String> userLowerBridge;
	private Integer userCurrentLocation; // 이거 integer 로 받아도 크기 충분한지 체크해야함

	public UserBridgeRepository() {
		this.userUpperBridge = new ArrayList<>();
		this.userLowerBridge = new ArrayList<>();
		this.userCurrentLocation = 0;
	}

	public void saveUserSpace(String Location, String userCurrentTrace) {
		userCurrentLocation++;
		if (Location.equals("U")) {
			this.userUpperBridge.add(userCurrentTrace);
			this.userLowerBridge.add(" ");
			return;
		}
		this.userUpperBridge.add(" ");
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

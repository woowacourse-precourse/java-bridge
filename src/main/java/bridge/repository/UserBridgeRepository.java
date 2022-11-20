package bridge.repository;

import bridge.domain.UserBridgeStatus;
import bridge.util.GameConst;

public class UserBridgeRepository {

	private Integer userCurrentLocation;

	public UserBridgeRepository() {
		this.userCurrentLocation = 0;
	}

	public void saveUserSpace(String location, String userCurrentTrace) {
		userCurrentLocation++;
		if (location.equals(GameConst.MOVING_UP)) {
			saveUserUpperSpace(userCurrentTrace);
			saveUserLowerSpace(GameConst.BLANK_SPACE);
			return;
		}
		saveUserUpperSpace(GameConst.BLANK_SPACE);
		saveUserLowerSpace(userCurrentTrace);
	}

	private void saveUserUpperSpace(String userCurrentTrace) {
		UserBridgeStatus.UPPER_BRIDGE.updateStatus(userCurrentTrace);
	}

	private void saveUserLowerSpace(String userCurrentTrace) {
		UserBridgeStatus.LOWER_BRIDGE.updateStatus(userCurrentTrace);
	}

	public String findUserBridgeStatus() {
		return UserBridgeStatus.UPPER_BRIDGE.statusToString(userCurrentLocation) + "\n"
			+ UserBridgeStatus.LOWER_BRIDGE.statusToString(userCurrentLocation);
	}

	public void clear() {
		UserBridgeStatus.UPPER_BRIDGE.clearStatus();
		UserBridgeStatus.LOWER_BRIDGE.clearStatus();
		userCurrentLocation = 0;
	}
}

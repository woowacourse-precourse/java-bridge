package bridge.repository;

import bridge.domain.UserBridgeStatus;
import bridge.util.InputViewConst;
import bridge.util.OutputViewConst;

public class UserBridgeRepository {

	private Integer userCurrentLocation;

	public UserBridgeRepository() {
		this.userCurrentLocation = 0;
	}

	public void saveUserSpace(String location, String userCurrentTrace) {
		userCurrentLocation++;
		if (location.equals(InputViewConst.MOVING_UP)) {
			UserBridgeStatus.UPPER_BRIDGE.updateStatus(userCurrentTrace);
			UserBridgeStatus.LOWER_BRIDGE.updateStatus(OutputViewConst.BLANK_SPACE);
			return;
		}
		UserBridgeStatus.UPPER_BRIDGE.updateStatus(OutputViewConst.BLANK_SPACE);
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

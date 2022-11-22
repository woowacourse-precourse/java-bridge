package bridge.repository;

import bridge.domain.UserBridgeGroup;
import bridge.util.GameConst;

public class UserBridgeRepository {

	private UserBridgeGroup userBridgeGroup;
	private Integer userCurrentLocation;

	public UserBridgeRepository() {
		userBridgeGroup = new UserBridgeGroup();
		this.userCurrentLocation = 0;
	}

	public void saveUserCorrectSpace(String location) {
		saveUserSpace(location, GameConst.USER_CORRECT_SPACE);
	}

	public void saveUserWrongSpace(String location) {
		saveUserSpace(location, GameConst.USER_WRONG_SPACE);
	}

	private void saveUserSpace(String location, String userCurrentTrace) {
		userCurrentLocation++;
		userBridgeGroup.updateStatus(location, userCurrentTrace);
	}

	public String findUserBridgeStatus() {
		return userBridgeGroup.statusToString(GameConst.MOVING_UP, userCurrentLocation) + "\n"
			+ userBridgeGroup.statusToString(GameConst.MOVING_DOWN, userCurrentLocation);
	}

	public void clear() {
		userBridgeGroup.clearStatus();
		userCurrentLocation = 0;
	}
}

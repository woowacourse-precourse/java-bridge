package bridge.repository;

import bridge.domain.UserBridgeGroup;
import bridge.util.GameConst;

public class UserBridgeRepository {

	private UserBridgeGroup userBridgeGroup;
	private Integer userCurrentIndex;
	private boolean userResult;

	public UserBridgeRepository() {
		userBridgeGroup = new UserBridgeGroup();
		this.userCurrentIndex = 0;
	}

	public void saveUserCorrectSpace(String location) {
		saveUserSpace(location, GameConst.USER_CORRECT_SPACE);
		userResult = true;
	}

	public void saveUserWrongSpace(String location) {
		saveUserSpace(location, GameConst.USER_WRONG_SPACE);
		userResult = false;
	}

	public boolean checkIsValidUserMove() {
		return userResult;
	}

	public Integer findUserCurrentIndex() {
		return userCurrentIndex;
	}

	private void saveUserSpace(String location, String userCurrentTrace) {
		userCurrentIndex++;
		userBridgeGroup.updateStatus(location, userCurrentTrace);
	}

	public String findUserBridgeStatus() {
		return userBridgeGroup.statusToString(GameConst.MOVING_UP, userCurrentIndex) + "\n"
			+ userBridgeGroup.statusToString(GameConst.MOVING_DOWN, userCurrentIndex);
	}

	public void clear() {
		userBridgeGroup.clearStatus();
		userCurrentIndex = 0;
	}
}

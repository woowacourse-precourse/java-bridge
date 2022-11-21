package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserBridgeGroup {

	private final String PREFIX = "[ ";
	private final String SUFFIX = " ]";
	private final String PARTITION = " | ";
	private final String BLANK_SPACE = " ";
	private final Map<UserBridge, List<String>> userBridgeStatus; // bridge 종류, 저장된 O,X," " 리스트

	public UserBridgeGroup() {
		this.userBridgeStatus = new HashMap<>();
		for (UserBridge value : UserBridge.values()) {
			userBridgeStatus.put(value, new ArrayList<>());
		}
	}

	public void updateStatus(String location, String status) {
		UserBridge userBridge = UserBridge.getUserBridgeStatus(location);
		userBridgeStatus.get(userBridge).add(status);
		UserBridge otherUserBridge = UserBridge.getOtherUserBridgeStatus(location);
		userBridgeStatus.get(otherUserBridge).add(BLANK_SPACE);
	}

	public String statusToString(String location, Integer bridgeSize) {
		UserBridge userBridge = UserBridge.getUserBridgeStatus(location);
		String statusToString = PREFIX;
		statusToString = addUserStatus(bridgeSize, userBridge, statusToString);
		return statusToString + SUFFIX;
	}

	private String addUserStatus(Integer bridgeSize, UserBridge userBridge, String statusToString) {
		for (int i = 0; i < bridgeSize; i++) {
			statusToString += userBridgeStatus.get(userBridge).get(i);
			if (i != bridgeSize - 1) {
				statusToString += PARTITION;
			}
		}
		return statusToString;
	}

	public void clearStatus() {
		for (UserBridge value : UserBridge.values()) {
			userBridgeStatus.get(value).clear();
		}
	}

}

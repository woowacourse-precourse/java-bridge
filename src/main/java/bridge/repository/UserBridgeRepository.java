package bridge.repository;

import java.util.ArrayList;
import java.util.List;

public class UserBridgeRepository {

	private List<String> userBridge;
	private Integer bridgeSize; // 이거 integer 로 받아도 크기 충분한지 체크해야함

	public UserBridgeRepository() {
		this.userBridge = new ArrayList<>();
	}

	public void initUserBridge(Integer bridgeSize) {
		this.bridgeSize = bridgeSize;
	}

	public void saveUserSpace(String userMoving) {
		this.userBridge.add(userMoving);
	}

	public List<String> findUserBridge() {
		return userBridge;
	}

}

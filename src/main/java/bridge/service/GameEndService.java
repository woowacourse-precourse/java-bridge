package bridge.service;

import bridge.repository.UserBridgeRepository;
import bridge.repository.UserBridgeStatusDto;

public class GameEndService {

	private final UserBridgeRepository userBridgeRepository;

	public GameEndService(UserBridgeRepository userBridgeRepository) {
		this.userBridgeRepository = userBridgeRepository;
	}

	public UserBridgeStatusDto getUserBridgeStatusDto() {
		return userBridgeRepository.findUserBridgeStatusDto();
	}
}

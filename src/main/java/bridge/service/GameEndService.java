package bridge.service;

import java.util.List;

import bridge.repository.UserBridgeRepository;

public class GameEndService {

	private final UserBridgeRepository userBridgeRepository;

	public GameEndService(UserBridgeRepository userBridgeRepository) {
		this.userBridgeRepository = userBridgeRepository;
	}

	public List<String> getUserMap() {
		return userBridgeRepository.findUserBridge();
	}
}

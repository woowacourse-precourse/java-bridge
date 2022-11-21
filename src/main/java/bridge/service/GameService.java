package bridge.service;

import java.util.List;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.repository.UserBridgeRepository;
import bridge.util.GameConst;

public class GameService {

	private final BridgeMaker bridgeMaker;
	private final Bridge bridge;
	private final UserBridgeRepository userBridgeRepository;

	public GameService(BridgeMaker bridgeMaker, Bridge bridge,
		UserBridgeRepository userBridgeRepository) {
		this.bridgeMaker = bridgeMaker;
		this.bridge = bridge;
		this.userBridgeRepository = userBridgeRepository;
	}

	public List<String> makeBridge(Integer bridgeSize) {
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
		this.bridge.initBridge(bridge);
		return bridge;
	}

	public String getUserBridgeStatus() {
		return userBridgeRepository.findUserBridgeStatus();
	}

	public String saveUserCorrectSpace(String userLocation) {
		userBridgeRepository.saveUserSpace(userLocation, GameConst.USER_CORRECT_SPACE);
		return userBridgeRepository.findUserBridgeStatus();
	}

	public String saveUserWrongSpace(String userLocation) {
		userBridgeRepository.saveUserSpace(userLocation, GameConst.USER_WRONG_SPACE);
		return userBridgeRepository.findUserBridgeStatus();
	}
}

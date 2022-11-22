package bridge.service;

import java.util.List;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.repository.UserBridgeRepository;
import bridge.util.GameConst;

public class BridgeGame {
	private final BridgeMaker bridgeMaker;
	private final Bridge bridge;
	private final UserBridgeRepository userBridgeRepository;

	public BridgeGame(BridgeMaker bridgeMaker, Bridge bridge,
		UserBridgeRepository userBridgeRepository) {
		this.bridgeMaker = bridgeMaker;
		this.bridge = bridge;
		this.userBridgeRepository = userBridgeRepository;
	}

	public List<String> makeBridge(Integer bridgeSize) {
		List<String> bridgeFromBridgeMaker = bridgeMaker.makeBridge(bridgeSize);
		bridge.initBridge(bridgeFromBridgeMaker);
		return bridgeFromBridgeMaker;
	}

	public String getUserBridgeStatus() {
		return userBridgeRepository.findUserBridgeStatus();
	}

	public boolean move(String userLocation, Integer currentLocation) {
		if (!bridge.checkValidSpace(userLocation, currentLocation)) {
			userBridgeRepository.saveUserWrongSpace(userLocation);
			return false;
		}
		userBridgeRepository.saveUserCorrectSpace(userLocation);
		return true;
	}

	public boolean retry(String userRestartCommand) {
		if (userRestartCommand.equals(GameConst.QUIT)) {
			return false;
		}
		clearBridgeGame();
		return true;
	}

	private void clearBridgeGame() {
		userBridgeRepository.clear();
	}
}

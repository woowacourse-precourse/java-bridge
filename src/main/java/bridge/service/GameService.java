package bridge.service;

import java.util.List;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.repository.UserBridgeRepository;
import bridge.repository.dto.UserBridgeStatusDto;
import bridge.util.OutputViewConst;

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

	public boolean checkValidSpace(String userSpace, Integer currentSpace) {
		return bridge.checkValidSpace(userSpace, currentSpace);
	}

	public UserBridgeStatusDto saveUserCorrectSpace(String userLocation) {
		userBridgeRepository.saveUserSpace(userLocation, OutputViewConst.USER_CORRECT_SPACE);
		return userBridgeRepository.findUserBridgeStatusDto();
	}

	public UserBridgeStatusDto saveUserWrongSpace(String userLocation) {
		userBridgeRepository.saveUserSpace(userLocation, OutputViewConst.USER_WRONG_SPACE);
		return userBridgeRepository.findUserBridgeStatusDto();
	}

	public UserBridgeStatusDto getUserBridgeStatusDto() {
		return userBridgeRepository.findUserBridgeStatusDto();
	}

	public void clearUserBridge() {
		userBridgeRepository.clear();
	}

}

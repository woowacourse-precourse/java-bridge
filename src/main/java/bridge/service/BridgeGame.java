package bridge.service;

import java.util.List;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.repository.UserBridgeRepository;
import bridge.util.GameConst;

public class BridgeGame {
	private final BridgeMaker bridgeMaker;
	private final UserBridgeRepository userBridgeRepository;
	private final Result result;
	private final Bridge bridge;

	public BridgeGame(BridgeMaker bridgeMaker, UserBridgeRepository userBridgeRepository, Bridge bridge) {
		this.bridgeMaker = bridgeMaker;
		this.userBridgeRepository = userBridgeRepository;
		this.bridge = bridge;
		this.result = new Result();
	}

	public List<String> makeBridge(Integer size) {
		List<String> newBridge = bridgeMaker.makeBridge(size);
		bridge.initBridge(newBridge, size);
		return newBridge;
	}

	public void attemptCountPlusOne() {
		result.attemptCountPlusOne();
	}

	public String getUserBridgeStatus() {
		return userBridgeRepository.findUserBridgeStatus();
	}

	public void move(String userLocation) {
		Integer userCurrentIndex = findUserLocation();
		if (!bridge.checkValidSpace(userLocation, userCurrentIndex)) {
			userBridgeRepository.saveUserWrongSpace(userLocation);
			return;
		}
		userBridgeRepository.saveUserCorrectSpace(userLocation);
	}

	public boolean checkIsEndSituation() {
		return userBridgeRepository.checkIsValidUserMove()
			&& !bridge.checkEndLocation(userBridgeRepository.findUserCurrentIndex());
	}

	public void organizeResult() {
		result.organizeResult(userBridgeRepository.checkIsValidUserMove());
	}

	public String findFinalResultToString() {
		return result.findFinalResultToString();
	}

	public Integer findUserLocation() {
		return userBridgeRepository.findUserCurrentIndex();
	}

	public boolean retry(String userRestartCommand) {
		if (userRestartCommand.equals(GameConst.QUIT)) {
			return false;
		}
		userBridgeRepository.clear();
		return true;
	}

	public boolean isFail() {
		return result.isFail();
	}
}

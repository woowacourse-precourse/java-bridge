package bridge.service;

import java.util.List;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.repository.UserBridgeRepository;
import bridge.util.GameConst;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
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

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move(String userLocation, Integer currentLocation) {
		if (!bridge.checkValidSpace(userLocation, currentLocation)) {
			userBridgeRepository.saveUserWrongSpace(userLocation);
			return false;
		}
		userBridgeRepository.saveUserCorrectSpace(userLocation);
		return true;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
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

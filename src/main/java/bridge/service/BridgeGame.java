package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final Bridge bridge;
	private int bridgeNumber = 0;

	public BridgeGame(int size) {
		bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size));
	}


	public BridgeStatus checkEnd() {
		if (bridge.isEnd(bridgeNumber))
			return BridgeStatus.END;
		return BridgeStatus.PASS;
	}
	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public BridgeStatus move(String input) {
		return bridge.isBridge(input, bridgeNumber++);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		bridgeNumber = 0;
	}
}

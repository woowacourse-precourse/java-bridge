package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeResult;
import bridge.domain.BridgeStatus;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final Bridge bridge;
	private int bridgeNumber = 0;
	private int tryCount = 0;
	private String gameResult;
	private BridgeResult bridgeResult;

	public BridgeGame(int size) {
		this.bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size));
		this.tryCount++;
	}

	public BridgeStatus checkEnd() {
		if (bridge.isEnd(bridgeNumber)) {
			return BridgeStatus.END;
		}

		return BridgeStatus.PASS;
	}

	public void checkClear(BridgeResult bridgeResult) {
		if (checkEnd() == BridgeStatus.END) {
			this.bridgeResult = bridgeResult;
			this.gameResult = "성공";
		}
	}

	public void end(BridgeResult bridgeResult) {
		while (!bridge.isEnd(bridgeNumber)) {
			bridgeNumber = bridge.getSize();
		}

		this.bridgeResult = bridgeResult;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public BridgeStatus move(String input) {
		return bridge.isBridgeStatus(input, bridgeNumber++);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		this.bridgeNumber = 0;
		this.gameResult = "실패";
		this.tryCount++;
	}

	@Override
	public String toString() {
		return String.format("%s\n게임 성공 여부: %s\n총 시도한 횟수: %d", bridgeResult, gameResult, tryCount);
	}
}

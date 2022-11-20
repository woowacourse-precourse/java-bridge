package bridge.domain;

import java.util.List;

import bridge.BridgeRandomNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
	private final List<String> bridge;
	private int gameStage;

	public BridgeGame(int bridgeSize) {
		this.bridge = bridgeMaker.makeBridge(bridgeSize);
		this.gameStage = 0;
	}

	/**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
	public String move() {
		String bridgeCommand = bridge.get(gameStage);
		gameStage += 1;
		return bridgeCommand;
	}

	/**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
	public void retry() {
		gameStage = 0;
	}

	public boolean isFinishGameStage(int bridgeSize) {
		return gameStage == bridgeSize;
	}
}

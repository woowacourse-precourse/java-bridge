package bridge.domain;

import java.util.List;

import bridge.domain.strategy.BridgeNumberGenerator;
import bridge.domain.strategy.BridgeRandomNumberGenerator;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final int bridgeSize;
	private final List<String> bridge;

	public BridgeGame(final int bridgeSize) {
		this.bridgeSize = bridgeSize;
		this.bridge = createBridge(bridgeSize);
	}

	private List<String> createBridge(final int bridgeSize) {
		BridgeNumberGenerator bridgeNumberGenerator = selectBridgeNumberGeneratorStrategy();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

		return bridgeMaker.makeBridge(bridgeSize);
	}

	private BridgeNumberGenerator selectBridgeNumberGeneratorStrategy() {
		return new BridgeRandomNumberGenerator();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(final String moving) {
		BridgeGameResult movingResults = getMovingResults(moving);
		increaseMoveCount();

		return movingResults;
	}

	private BridgeGameResult getMovingResults(final String moving) {
		return BridgeGameResultCalculator.getMovingResults(bridge, moving);
	}

	private void increaseMoveCount() {
		BridgeGameResult.increaseMoveCount();
	}

	public boolean isGameProcessing() {
		return BridgeGameResult.isGameProcessing();
	}

	public boolean isGameEnd() {
		return BridgeGameResult.isGameEnd();
	}

	public boolean isGameFailed() {
		return BridgeGameResult.isGameFailed();
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
	}
}

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
	private int totalTryCount;

	public BridgeGame(final int bridgeSize) {
		this.bridgeSize = bridgeSize;
		this.bridge = createBridge(bridgeSize);
		totalTryCount = 1;
	}

	private List<String> createBridge(final int bridgeSize) {
		BridgeNumberGenerator bridgeNumberGenerator = selectBridgeNumberGeneratorStrategy();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

		return bridgeMaker.makeBridge(bridgeSize);
	}

	private BridgeNumberGenerator selectBridgeNumberGeneratorStrategy() {
		return new BridgeRandomNumberGenerator();
	}

	public BridgeGameResult move(final String moving) {
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

	public void retry() {
		changeGameStatusToProcessingIfRestart();
		increaseTotalTryCount();
		resetGameRecords();
	}

	private void resetGameRecords() {
		BridgeGameResult.resetResult();
	}

	public void changeGameStatusToProcessingIfRestart() {
		BridgeGameResult.changeGameStatusToProcessing();
	}

	public void increaseTotalTryCount() {
		totalTryCount++;
	}

	public String getFinalGameStatus() {
		return BridgeGameResult.getFinalGameStatus();
	}

	public int getTotalTryCount() {
		return totalTryCount;
	}

}

package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameManager {
	private final BridgeGame bridgeGame;
	private final InputView inputView;
	private final OutputView outputView;

	public BridgeGameManager() {
		inputView = new InputView();
		outputView = new OutputView();

		int bridgeSize = inputView.readBridgeSize();
		bridgeGame = new BridgeGame(bridgeSize);
	}

	public void run() {
		boolean roundResult = false;
		String retryOrEnd = "";
		while (!(bridgeGame.doesCrossedBridge() || retryOrEnd.equals("Q"))) {
			roundResult = roundRun();
			if (roundResult == false) {
				retryOrEnd = inputView.readGameCommand();
				bridgeGame.retry(retryOrEnd);
			}
		}

		outputView.printResult(bridgeGame, roundResult);
	}

	public boolean roundRun() {
		String userPath = inputView.readMoving(); //InputView 클래스 사용
		boolean roundResult = bridgeGame.move(userPath); //BridgeGame 클래스 사용
		outputView.printMap(bridgeGame.getPassedPaths(), roundResult); //OutputView 클래스 사용

		return roundResult;
	}
}

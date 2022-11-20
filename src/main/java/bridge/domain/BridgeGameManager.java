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
		String retryOrEnd = "";
		while (!(bridgeGame.doesCrossedBridge() || retryOrEnd.equals("Q"))) {
			roundRun();
			if (bridgeGame.getLastRoundResult() == false) {
				retryOrEnd = inputView.readGameCommand();
				bridgeGame.retry(retryOrEnd);
			}
		}

		outputView.printResult(bridgeGame);
	}

	private void roundRun() {
		String userPath = inputView.readMoving();
		bridgeGame.move(userPath);
		outputView.printMap(bridgeGame);
	}
}

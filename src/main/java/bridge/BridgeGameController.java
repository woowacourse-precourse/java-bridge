package bridge;

import bridge.enums.Inputs;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private BridgeGame bridgeGame;

	public BridgeGameController() {
		int bridgeSize = inputView.readBridgeSize();
		bridgeGame = new BridgeGame(bridgeSize, new BridgeRandomNumberGenerator());
	}

	public void run() {
		outputView.printInitMessage();
		while (!bridgeGame.gameWon()) {
			if (isGameFailEnded()) {
				return;
			}
		}
		outputView.printResult(bridgeGame);
	}

	private boolean isGameFailEnded() {
		if (!isMoveSuccessful()) {
			if (!isPlayerRetry()) {
				return true;
			}
		}
		return false;
	}

	public boolean isMoveSuccessful() {
		Inputs input = inputView.readMoving();
		boolean moveSuccess = bridgeGame.move(input);
		outputView.printMap(bridgeGame);
		return moveSuccess;
	}

	public boolean isPlayerRetry() {
		String retry = inputView.readGameCommand();
		if (retry.equals(Inputs.RETRY.getMessage())) {
			bridgeGame.retry();
			return true;
		}
		outputView.printResult(bridgeGame);
		return false;
	}
}

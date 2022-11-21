package bridge.domain;

import static bridge.utils.GameMessageConstants.BRIDGE_SIZE_REQUEST_MESSAGE;
import static bridge.utils.GameMessageConstants.GAME_START_MESSAGE;
import static bridge.utils.GameMessageConstants.MOVING_PATH_REQUEST_MESSAGE;
import static bridge.utils.GameMessageConstants.RETRY_OR_END_COMMAND_REQUEST_MESSAGE;

import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameManager {
	private final BridgeGame bridgeGame;
	private final InputView inputView;
	private final OutputView outputView;

	public BridgeGameManager() {
		inputView = new InputView();
		outputView = new OutputView();

		outputView.printGameMessage(BRIDGE_SIZE_REQUEST_MESSAGE);
		bridgeGame = new BridgeGame(inputView.readBridgeSize());
	}

	public void run() {
		outputView.printGameMessage(GAME_START_MESSAGE);
		String retryOrEnd = "";
		while (!(bridgeGame.doesCrossedBridge() || retryOrEnd.equals("Q"))) {
			roundRun();
			if (bridgeGame.getLastRoundResult() == false) {
				retryOrEnd = chooseRetryOrEnd();
			}
		}
	}

	private void roundRun() {
		outputView.printGameMessage(MOVING_PATH_REQUEST_MESSAGE);
		String userPath = inputView.readMoving();
		bridgeGame.move(userPath);
		outputView.printMap(bridgeGame);
	}

	private String chooseRetryOrEnd() {
		outputView.printGameMessage(RETRY_OR_END_COMMAND_REQUEST_MESSAGE);
		String gameCommand = inputView.readGameCommand();
		if (gameCommand.equals("R")) {
			bridgeGame.retry(gameCommand);
		}

		return gameCommand;
	}

	public void printGameResult() {
		outputView.printResult(bridgeGame);
	}
}

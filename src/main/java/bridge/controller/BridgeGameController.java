package bridge.controller;

import bridge.BridgeGame;
import bridge.GameCommand;
import bridge.MoveCode;
import bridge.io.InputView;
import bridge.io.OutputView;

public class BridgeGameController {

	private OutputView outputView = new OutputView();
	private InputView inputView = new InputView();
	private BridgeGame bridgeGame = null;

	public void startGame() {
		makeBridge();
		move(bridgeGame);
		retry(bridgeGame);
		outputView.printResult(bridgeGame.calculateGameResult());
	}

	private void makeBridge() {
		while(true) {
			try {
				outputView.printStartMessage();
				bridgeGame = new BridgeGame(inputView.readBridgeSize());
				break;
			} catch (IllegalArgumentException e) {
				outputView.printError(e.getMessage());
			}
		}
	}

	private void move(BridgeGame bridgeGame) {
		while(bridgeGame.canGoOn()) {
			try {
				outputView.printRequestInputMoveCodeMessage();
				MoveCode moveCode = MoveCode.getMoveCodeByInputCode(inputView.readMoving());
				outputView.saveEachMap(moveCode, bridgeGame.move(moveCode));
				outputView.printMap();
			} catch (Exception e) {
				outputView.printError(e.getMessage());
			}
		}
	}

	private void retry(BridgeGame bridgeGame) {
		while(bridgeGame.calculateGameResult().isLosing()) {
			try {
				outputView.printRequestInputGameCommandMessage();

				if (GameCommand.QUIT == GameCommand.getGameCommandByGameCommandCode(inputView.readGameCommand())) {
					break;
				}

				bridgeGame.retry();
				move(bridgeGame);
			} catch (Exception e) {
				outputView.printError(e.getMessage());
			}
		}
	}
}

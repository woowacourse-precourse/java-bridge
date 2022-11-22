package controller;

import static model.BridgeGameConstants.MOVING_SUCCESS;
import static model.BridgeGameConstants.MOVING_SUCCESS_GAME_END;

import static view.InputViewConstants.GAME_COMMAND_QUIT;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import model.BridgeGame;

import view.InputView;
import view.OutputView;

public class BridgeGameController {

	private final BridgeGame bridgeGame;
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();

	public BridgeGameController() {
		gameStart();
		BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
		bridgeGame = new BridgeGame(bridgeMaker.makeBridge(readBridgeSize()));
	}

	public void gameProgress() {
		while (true) {
			int movingResult = playerMoving();
			if (movingResult == MOVING_SUCCESS) {
				continue;
			}
			if (gameEnd(movingResult)) {
				printGameResult(movingResult, bridgeGame.getGameRoundCount());
				break;
			}
			gameReset();
		}
	}

	private boolean gameEnd(int movingResult) {
		if (movingResult == MOVING_SUCCESS_GAME_END) {
			return true;
		}
		if (readGameCommand().equals(GAME_COMMAND_QUIT)) {
			return true;
		}
		return false;
	}

	private void gameReset() {
		outputView.clearGameStateMap(); // -> 이 호출을 outputView가 하게 하면?
		bridgeGame.retry(); // -> 이 호출을 bridgeGame이 하
	}

	private void gameStart() {
		outputView.printGameStartMessage();
	}

	private int readBridgeSize() {
		return inputView.readBridgeSize();
	}

	private int playerMoving() {
		String moving = readMoving();
		int movingResult = bridgeGame.move(moving);
		printCurrentGameState(moving, movingResult);
		return movingResult;
	}

	private String readMoving() {
		return inputView.readMoving();
	}

	private void printCurrentGameState(String moving, int movingResult) {
		outputView.printMap(moving, movingResult);
	}

	private String readGameCommand() {
		return inputView.readGameCommand();
	}

	private void printGameResult(int movingResult, int gameRound) {
		outputView.printResult(movingResult, gameRound);
	}

}
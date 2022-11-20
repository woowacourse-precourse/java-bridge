package controller;

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
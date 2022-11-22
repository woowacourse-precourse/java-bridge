package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.game.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeController {

	OutputView outputView;
	InputView inputView;
	BridgeGame bridgeGame;

	public BridgeController() {
		this.outputView = new OutputView();
		this.inputView = new InputView();
		this.bridgeGame = new BridgeGame();
	}

	public void run() {
		outputView.printStartGame();
		makeBridge();
		play();
		endGame();
	}

	public void makeBridge() {
		int size = askBridgeSize();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		List<String> bridges = bridgeMaker.makeBridge(size);
		System.out.println(bridges);
		bridgeGame.setBridges(bridges);
	}

	public int askBridgeSize() {
		while (true) {
			try {
				return inputView.readBridgeSize();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void play() {
		while (bridgeGame.canPlay()) {
			String moveCommand = askMove();
			bridgeGame.move(moveCommand);
			outputView.printMap(bridgeGame);
			if (bridgeGame.isFailStage()) {
				askRetry();
			}
		}
	}

	public String askMove() {
		while (true) {
			try {
				String moveCommand = inputView.readMoving();
				return moveCommand;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void askRetry() {
		try {
			String retryCommand = inputView.readGameCommand();
			bridgeGame.retry(retryCommand);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			askRetry();
		}
	}

	public void endGame() {
		outputView.printResult(bridgeGame);
	}

}

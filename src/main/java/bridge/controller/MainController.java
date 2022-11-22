package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Constants;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class MainController {

	private final InputView inputView;
	private final OutputView outputView;
	private BridgeGame bridgeGame;

	public MainController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
		initGame();
	}

	private void initGame() {
		outputView.printStart();
		bridgeGame = createBridgeGame();
	}

	private BridgeGame createBridgeGame() {
		try {
			BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
			List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
			return new BridgeGame(bridge);
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			return createBridgeGame();
		}
	}

	public void run() {
		while (!bridgeGame.checkSituation().isSuccess()) {
			move();
			if (bridgeGame.checkSituation().isFail() && !doRetry()) {
				break;
			}
		}
		outputView.printResult(bridgeGame);
	}

	private void move() {
		try {
			String moving = inputView.readMoving();
			bridgeGame.move(moving);
			outputView.printMap(bridgeGame.getGameRecord());
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			move();
		}
	}

	private boolean doRetry() {
		String gameCommand;
		try {
			gameCommand = inputView.readGameCommand();
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception.getMessage());
			return doRetry();
		}
		return doRetry(gameCommand);
	}

	private boolean doRetry(String gameCommand) {
		if (gameCommand.equals(Constants.RETRY)) {
			bridgeGame.retry();
			return true;
		}
		return false;
	}
}

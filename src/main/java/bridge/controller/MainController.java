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
		int bridgeSize = inputView.readBridgeSize();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
		bridgeGame = new BridgeGame(bridge);
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
		String moving = inputView.readMoving();
		bridgeGame.move(moving);
		outputView.printMap(bridgeGame.getGameRecord());
	}

	private boolean doRetry() {
		String gameCommand = inputView.readGameCommand();
		if (gameCommand.equals(Constants.RETRY)) {
			bridgeGame.retry();
			return true;
		}
		return false;
	}
}

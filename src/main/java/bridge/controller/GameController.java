package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	private BridgeGame bridgeGame;

	public void run() {
		OutputView.printGameStart();
		setting();
		progress();
	}

	private void setting() {
		User user = new User();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
		bridgeGame = new BridgeGame(user, bridge);
	}

	private void progress() {
		boolean isEnd = true;
		while (isEnd) {
			bridgeGame.move(InputView.readMoving());
			OutputView.printMap(bridgeGame.currentMap());
			isEnd = bridgeGame.checkEnd();
		}

	}

}

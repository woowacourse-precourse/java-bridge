package bridge;

import bridge.view.InputView;

public class BridgeGameController {
	private final BridgeGame bridgeGame;
	private final InputView inputView;

	BridgeGameController() {
		this.inputView = new InputView();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		this.bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
	}

	public void gameStart() {
		Boolean success = false;
		while (bridgeGame.move(inputView.readMoving())) {
			// move한 결과를 저장함
		}
		if (success == false) {
			if (inputView.readGameCommand() == "Q") {
				return ;
			}
			if (inputView.readGameCommand() == "R") {
				gameStart();
			}
		}
	}
}

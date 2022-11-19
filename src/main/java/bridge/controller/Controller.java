package bridge.controller;

import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.bridgeMaker.BridgeRandomNumberGenerator;
import bridge.domain.game.BridgeGame;
import bridge.domain.result.ResultRendering;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

	public void run() {
		InputView inputView = new InputView();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		BridgeGame bridgeGame = new BridgeGame();

		bridgeGame.play(inputView, bridgeMaker);
		OutputView.withContentOf(ResultRendering.renderFinalResult(bridgeGame.getGameResult()), false, false).ConsoleMessage();
	}
}

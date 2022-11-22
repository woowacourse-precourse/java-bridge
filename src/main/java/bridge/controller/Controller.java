package bridge.controller;

import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.bridgeMaker.BridgeRandomNumberGenerator;
import bridge.domain.game.BridgeGame;
import bridge.domain.result.ResultRendering;
import bridge.view.output.OutputView;

public class Controller {

	public void run() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		BridgeGame bridgeGame = new BridgeGame();

		bridgeGame.play(bridgeMaker);
		OutputView.withContentOf(ResultRendering.renderFinalResult(bridgeGame.getGameResult()), true, false).ConsoleMessage();
	}
}

package bridge.controller;

import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.bridgeMaker.BridgeRandomNumberGenerator;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.ResultRendering;
import bridge.view.output.OutputView;

public class Controller {

	private static final String GAME_START_INFO = "다리 건너기 게임을 시작합니다.";

	public void run() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		BridgeGame bridgeGame = new BridgeGame();

		OutputView.withContentOf(GAME_START_INFO, false, true).ConsoleMessage();
		bridgeGame.play(bridgeMaker);
		OutputView.withContentOf(ResultRendering.renderFinalResult(bridgeGame.getGameResult()), true, false).ConsoleMessage();
	}
}

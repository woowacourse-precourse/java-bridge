package bridge.controller;

import bridge.domain.game.BridgeGame;
import bridge.domain.bridgeMaker.BridgeMaker;
import bridge.domain.bridgeMaker.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

	private static final String EXIT_MESSAGE = "게임을 종료합니다.";
	private static final String ENTER = "\n";

	public void run() {
		try {
			InputView inputView = new InputView();
			BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
			BridgeGame bridgeGame = new BridgeGame();

			bridgeGame.play(inputView, bridgeMaker);
		} catch (IllegalArgumentException ignored) {
		} finally {
			OutputView.printGameInfo(ENTER + EXIT_MESSAGE);
		}
	}
}

package controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeSize;
import bridge.MapRenderer;
import view.InputView;
import view.OutputView;

public class GameController {
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	public void control() {
		BridgeGame bridgeGame = new BridgeGame();

		Bridge bridge = init();
		String result = run(bridge, bridgeGame);
		end(result, bridgeGame);
	}


}

package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	public void run() {
		OutputView.printGameStart();
		setting();
	}

	private void setting() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		Bridge bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
	}
}

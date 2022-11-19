package bridge.controller;

import static bridge.view.ProgressMessage.*;

import bridge.domain.BridgeGameInitialization;
import bridge.view.OutputView;
import bridge.vo.Bridge;

public class BridgeGameController {
	BridgeGameInitialization bridgeGameInitialization;

	public void playBridgeGame() {

	}

	/*private void initBridgeGame() {
		int bridgeSize = getBridgeSize();
	}*/

	private void startBridgeGame() {
		OutputView.printProgressMessage(GAME_START);
		OutputView.printProgressMessage(CHOICE_MOVE_STEP);
		Bridge bridge = bridgeGameInitialization.initBridge();
	}

}

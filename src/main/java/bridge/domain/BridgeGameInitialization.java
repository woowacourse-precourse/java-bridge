package bridge.domain;

import static bridge.view.ProgressMessage.*;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Bridge;

public class BridgeGameInitialization {
	BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private Bridge bridge;

	public Bridge initBridge() {
		int bridgeSize = setBridgeSize();
		setBridge(bridgeSize);
		return bridge;
	}

	private int setBridgeSize() {
		try {
			return InputView.readBridgeSize();
		} catch (IllegalArgumentException e) {
			OutputView.printErrorMessage(e.getMessage());
			OutputView.printProgressMessage(INPUT_AGAIN);
			return setBridgeSize();
		}
	}

	private void setBridge(int bridgeSize) {
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
		bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
	}
}

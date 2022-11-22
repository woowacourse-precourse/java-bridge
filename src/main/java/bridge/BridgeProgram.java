package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeProgram {
	private final InputView inputView = new InputView();
	private final BridgeGame bridgeGame = new BridgeGame();
	private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
	private final Bridge bridge = new Bridge();
	private final OutputView outputView = new OutputView();

	private final List<String> upBridge = new ArrayList<>();
	private final List<String> downBridge = new ArrayList<>();

	private int count = 1;
	private int stack = 0;

	public void useBridge() {
		bridge.matchBridge(bridgeMaker.makeBridge(checkBridgeSizeInputOrMove()));
	}

	private int checkBridgeSizeInputOrMove() {
		try {
			return inputView.readBridgeSize();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkBridgeSizeInputOrMove();
		}
	}

	private String checkMovingInput() {
		try {
			return inputView.readMoving();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return checkMovingInput();
		}
	}
}

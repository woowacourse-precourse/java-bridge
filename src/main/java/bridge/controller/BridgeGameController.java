package bridge.controller;

import java.util.ArrayList;
import java.util.List;

import bridge.service.BridgeGameService;
import bridge.view.InputView;

public class BridgeGameController {
	private final InputView inputView = new InputView();
	private final BridgeGameService bridgeGameService;

	public BridgeGameController() {
		this.bridgeGameService = new BridgeGameService();
	}

	public void start() {
		List<String> bridge = receiveBridgeSize();
	}

	private List<String> receiveBridgeSize() {
		try {
			int size = inputView.readBridgeSize();
			return bridgeGameService.initBridge(size);
		}  catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return receiveBridgeSize();
		}
	}
}

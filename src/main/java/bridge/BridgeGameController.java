package bridge;

import java.util.List;

public class BridgeGameController {
	
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
	
	public void startGame() {
		outputView.gameStartMessage();
		List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
		
	}
}

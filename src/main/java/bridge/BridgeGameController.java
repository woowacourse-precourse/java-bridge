package bridge;

import java.util.List;

public class BridgeGameController {
	
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
	private final BridgeGame bridgeGame = new BridgeGame();
	
	public void startGame() {
		outputView.gameStartMessage();
		List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
		playGame(bridge);
		
	}
	
	private void playGame(List<String> bridge) {
		boolean flag = true;
		int bridgeLevel = 0;
		System.out.println(bridge);
		do {
			if(bridge.size() == bridgeLevel) {
				break;
			}
			boolean isCorrect = bridgeGame.move(bridge.get(bridgeLevel),inputView.readMoving());
			outputView.printMap(bridgeLevel, isCorrect, bridge);
			bridgeLevel++;
		}while(flag);
	}
	
	
}

package bridge;

import java.util.List;

public class BridgeGameController {
	
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
	private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
	private final BridgeGame bridgeGame = new BridgeGame();
	private static List<String> bridge;
	private static int retryCount = 1;
	public void startGame() {
		outputView.gameStartMessage();
		bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
		playGame(bridge);
		
	}
	
	public void playGame(List<String> bridge) {
		int bridgeLevel = 0;
		System.out.println(bridge);
		do {
			if(bridge.size() == bridgeLevel) {
				outputView.printResult(retryCount,true);
				break;
			}
			if(!playOneTurn(bridge,bridgeLevel)) {
				break;
			}
			++bridgeLevel;
		}while(true);
	}
	
    private boolean isRetryOrNot(String command) {
    	if(command.equals("R")) {
    		retryCount++;
			playGame(bridge);
			return false;
		}
    	outputView.printResult(retryCount,false);
    	return false;
    }
    
    private boolean playOneTurn(List<String> bridge,int bridgeLevel) {
    	boolean isRightMoving = bridgeGame.move(bridge.get(bridgeLevel),inputView.readMoving());
		outputView.printMap(bridgeLevel, isRightMoving, bridge);
		if(!isRightMoving) {
			return isRetryOrNot(inputView.readGameCommand());
    	}
		return true;
    }

	
}

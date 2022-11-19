package bridge;

import java.util.List;

public class BridgeGameController {
	
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
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
		while(true) {
			if(isGameEnd(bridge,bridgeLevel)) {
				break;
			}
			++bridgeLevel;
		}
	}
	private boolean isGameEnd(List<String> bridge,int bridgeLevel) {
		if(bridge.size() == bridgeLevel) {
			outputView.printResult(retryCount,true);
			return true;
		}
		if(!playOneTurn(bridge,bridgeLevel)) {
			return true;
		}
		return false;
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

package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
	static List<String> madeBridge = new ArrayList<>();
	static int bridgeSize = 0;
	static String inputMoving = "";
	static String restartOrQuit = "";
	
	static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeSize = inputView.readBridgeSize();
    	BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    	madeBridge = bridgeMaker.makeBridge(bridgeSize);
        
    }
    
    public static void inputBridgeState() {
    	for(int order = 0; order < bridgeSize; order++) {      	
        	inputMoving = inputView.readMoving();
        	if(!bridgeGame.move(inputMoving, madeBridge, bridgeSize)) {
        		restartOrQuit = bridgeGame.retry();
        		break;
        	}
        }
    }
}

package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
	static List<String> madeBridge = new ArrayList<>();
	static int bridgeSize = 0;
	static String inputMoving = "";
	static String restartOrQuit = "";
	static int tryCount = 1;
	static boolean check = false;
	static InputView inputView = new InputView();
	static OutputView outputView = new OutputView();
    
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeSize = inputView.readBridgeSize();
    	BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    	madeBridge = bridgeMaker.makeBridge(bridgeSize);
    	do {
    		check = inputBridgeState();
    		tryCount++;
    	} while(check);
    	outputView.printResult();
    }
    
    public static boolean inputBridgeState() {
    	BridgeGame bridgeGame = new BridgeGame();
    	for(int order = 0; order < bridgeSize; order++) {      	
        	inputMoving = inputView.readMoving();
        	if(!bridgeGame.move(inputMoving, madeBridge, bridgeSize)) {
        		return bridgeGame.retry();                   // 재시도할 경우 return true. 게임 종료의 경우 return false.
        	}
        }
    	return false;   // 다리를 다 건넜을 때 return false.
    }
    
}

package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
	static List<String> madeBridge = new ArrayList<>();
	static int bridgeSize = 0;
	static String inputMoving = "";
	
	static InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        
        while(true) {
        	bridgeSize = inputView.readBridgeSize();
        	BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        	BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        	madeBridge = bridgeMaker.makeBridge(bridgeSize);
        	inputMoving = inputView.readMoving();
        	
        }
    }
}

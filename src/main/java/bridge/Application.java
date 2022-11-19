package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.InputView;
import bridge.domain.OutputView;

public class Application {
	static List<String> madeBridge = new ArrayList<>();
	static int bridgeSize = 0;
	static String inputMoving = "";
	static String restartOrQuit = "";
	static int tryCount = 0;
	static boolean retrycheck = false;
	static String successOrFailure = "실패";
	static String currentStateBridge = "";
	static InputView inputView = new InputView();
	static OutputView outputView = new OutputView();
    
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeSize = inputView.readBridgeSize();
    	BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    	madeBridge = bridgeMaker.makeBridge(bridgeSize);
    	do {
    		retrycheck = inputBridgeState();
    		tryCount++;
    	} while(retrycheck);
    	outputView.printResult(tryCount, currentStateBridge, successOrFailure);
    }
    
    public static boolean inputBridgeState() {
    	BridgeGame bridgeGame = new BridgeGame(bridgeSize);
    	for(int order = 0; order < bridgeSize; order++) {      	
        	inputMoving = inputView.readMoving();
        	if(!bridgeGame.move(inputMoving, madeBridge, order)) {
        		currentStateBridge = outputView.getCurrentStateBridge();
        		return bridgeGame.retry();                   // 재시도할 경우 return true. 게임 종료의 경우 return false.
        	}
        }
    	currentStateBridge = outputView.getCurrentStateBridge();
    	checkSuccessOrFailure(bridgeGame);
    	return false;   // 다리를 다 건넜을 때 return false.
    }
    
    public static void checkSuccessOrFailure(BridgeGame bridgeGame) {
    	successOrFailure = bridgeGame.checkSuccessFailure();
    }
    
}

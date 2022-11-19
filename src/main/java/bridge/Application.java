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
    		BridgeGame bridgeGame = new BridgeGame(bridgeSize);
    		retrycheck = inputBridgeState(bridgeGame);
    		tryCount++;
    	} while(retrycheck);
    	outputView.printResult(tryCount, currentStateBridge, successOrFailure);
    }
    
    public static boolean inputBridgeState(BridgeGame bridgeGame) {
    	for(int order = 0; order < bridgeSize; order++) {      	
        	inputMoving = inputView.readMoving();
        	if(!bridgeGame.move(inputMoving, madeBridge, order)) {
        		currentStateBridge = outputView.getAndPrintCurrentStateBridge(bridgeGame.getUpDownBridgeList()); // 재시도나 quit종료를 하기 전에 현재 다리 상태 저장
        		return bridgeGame.retry(inputView.getRestartOrQuit());                   // 재시도할 경우 return true. 게임 종료의 경우 return false.
        	}
        	successBridgeState(bridgeGame);
        	outputView.printCurrentStateBridge(bridgeGame.getUpDownBridgeList());  // 현재 다리의 상태를 출력해줌
        }
    	
    	return false;   // 다리를 다 건넜을 때 return false.
    }
    
    public static void checkSuccessOrFailure(BridgeGame bridgeGame) {
    	successOrFailure = bridgeGame.checkSuccessFailure();
    }
    
    public static void successBridgeState(BridgeGame bridgeGame) {
    	currentStateBridge = outputView.getCurrentStateBridge(bridgeGame.getUpDownBridgeList());  // 다릐를 모두 건넜을 때 현재 다리 상태 저장
    	checkSuccessOrFailure(bridgeGame);  // 
    }
}

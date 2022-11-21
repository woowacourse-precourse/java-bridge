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
	static boolean retrycheck = false;
	static String currentStateBridge = "";
	static InputView inputView;
	static OutputView outputView = new OutputView();
    static BridgeGame bridgeGame;
    static BridgeNumberGenerator bridgeNumberGenerator;
    
    public static void main(String[] args) {
    	int tryCount = 0;   	
    	makeBridgeFirst();
    	do {
    		bridgeGame = new BridgeGame(bridgeSize);  // retry할 때마다 bridgeGame을 다시 시작함(객체 다시 생성)
    		retrycheck = inputBridgeState(bridgeGame);
    		tryCount++;
    	} while(retrycheck);
    	outputView.printResult(tryCount, currentStateBridge, checkSuccessOrFailure(bridgeGame));
    }
    
    public static void makeBridgeFirst() {
    	System.out.println("\n\n다리 건너기 게임을 시작합니다.");
    	bridgeSize = 0;
    	inputView = new InputView();
        bridgeSize = inputView.readBridgeSize();
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
     	BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
     	madeBridge = bridgeMaker.makeBridge(bridgeSize);
    }
    
    public static boolean inputBridgeState(BridgeGame bridgeGame) {
    	for(int order = 0; order < bridgeSize; order++) {      	
        	inputMoving = inputView.readMoving();
        	if(!bridgeGame.move(inputMoving, madeBridge, order)) {
        		currentStateBridge = outputView.getAndPrintCurrentStateBridge(bridgeGame.getUpDownBridgeList()); // 재시도나 quit종료를 하기 전에 현재 다리 상태 저장
        		return bridgeGame.retry(inputView.getRestartOrQuit());                   // 재시도할 경우 return true. 게임 종료의 경우 return false.
        	}
        	outputView.printCurrentStateBridge(bridgeGame.getUpDownBridgeList());  // 현재 다리의 상태를 출력해줌
        }
    	successBridgeState(bridgeGame);
    	return false;   // 다리를 다 건넜을 때 성공이므로(재시도가 아니므로) return false.
    }
    
    public static String checkSuccessOrFailure(BridgeGame bridgeGame) {
    	String successOrFailure = "실패";
    	successOrFailure = bridgeGame.checkSuccessFailure();
    	return successOrFailure;
    }
    
    public static void successBridgeState(BridgeGame bridgeGame) {
    	currentStateBridge = outputView.getCurrentStateBridge(bridgeGame.getUpDownBridgeList());  // 다릐를 모두 건넜을 때 현재 다리 상태 저장
    	checkSuccessOrFailure(bridgeGame);  // 다리를 성공적으로 건넜을 때 성공여부는 성공임.
    }
}

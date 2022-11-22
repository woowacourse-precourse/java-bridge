package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeResult;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final String FAIL = "실패";
    private static final String SUCCESS = "성공";


    private Bridge makeBridge(){
        int bridgeSize = inputView.readBridgeSize();    // 1. 다리의 길이를 입력받는다.
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();    // 2. 다리를 생성한다.
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        return bridge;
    }

    private String crossBridge(Bridge bridge, BridgeGame bridgeGame){
        String command = inputView.readMoving();    // 3. 이동할 칸을 입력받는다.
        int currentLocation = bridgeGame.getCurrentLocation();
        String movingResult = bridge.movingResult(currentLocation, command);    // 4. 이동할 칸이 건널 수 있는 칸인지 체크한다
        bridgeGame.move(command, movingResult); // 5. 해당 칸으로 플레이어를 이동시킨다.
        outputView.printMap(bridgeGame.getBridgeResult());  // 6. 현재까지 이동한 다리의 상태를 출력한다.
        return movingResult;
    }

    private boolean proceedGame(Bridge bridge, BridgeGame bridgeGame){
        String movingResult = crossBridge(bridge, bridgeGame);
        // 7. 건널 수 없는 칸을 건너려했을 때, 재시작 혹은 종료할 지 입력받는다.
        if (movingResult.equals("X")){
            if (isQuit()){
                return false;
            }
            bridgeGame.retry();     // 8. 재시작을 입력받았을 경우에 게임을 재시작한다.
        }
        return true;
    }

    private boolean isQuit(){
        String command = inputView.readGameCommand();
        // 9. 다리를 모두 건너거나 게임을 종료했을 경우 최종 결과를 출력한다.
        if (command.equals("Q")){
            return true;
        }
        return false;
    }

    public void run(){
        Bridge bridge = makeBridge();
        BridgeGame bridgeGame = new BridgeGame();
        while (bridgeGame.getCurrentLocation() < bridge.getSize()){
            if (!proceedGame(bridge, bridgeGame)){
                outputView.printResult(bridgeGame.getBridgeResult(), FAIL, bridgeGame.getTries());
                return;
            }
        }
        outputView.printResult(bridgeGame.getBridgeResult(), SUCCESS, bridgeGame.getTries());
    }
}

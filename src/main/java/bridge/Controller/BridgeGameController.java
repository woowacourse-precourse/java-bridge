package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeResult;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class BridgeGameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;
    BridgeResult bridgeResult = new BridgeResult();


    public void run(){
        // 1. 다리의 길이를 입력받는다.
        int bridgeSize = inputView.readBridgeSize();
        // 2. 다리를 생성한다.
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));

        int tries = 1;
        String result = "성공";
        for (int i = 0; i < bridgeSize; i++){
            // 3. 이동할 칸을 입력받는다.
            String command = inputView.readMoving();
            // 4. 해당 칸으로 플레이어를 이동시킨다.
            bridgeResult = bridgeGame.move(i, command, bridgeResult);
            // 5. 현재까지 이동한 다리의 상태를 출력한다.
            outputView.printMap(bridgeResult);
            // 6. 건널 수 없는 칸을 건너려했을 때, 재시작 혹은 종료할 지 입력받는다.
            if (bridgeResult.getLastResult().equals("X")){
                command = inputView.readGameCommand();
                if (command.equals("Q")){
                    result = "실패";
                    break;
                }
                i = -1;
                tries++;
                bridgeGame.retry(bridgeResult);
            }
        }
        outputView.printResult(bridgeResult, result, tries);
    }
}

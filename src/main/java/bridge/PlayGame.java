package bridge;

import data.OutputForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PlayGame {
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    OutputView outputView = new OutputView();
    int bridgeSize_Input = 0;
    List<String> bridge = new ArrayList<>();
    Boolean startGame = true;
    int roundCnt = 0;
    String success;

    public void play() {
        start();
        while (startGame) {
            Boolean out_Of_Game = true;
            Map<Integer, String> map;
            int bridgeIndex = 0;
            int i = 0;
            while (i < bridgeSize_Input && out_Of_Game) {
                String move_Input = inputView.readMoving();
                bridgeGame.move(move_Input, bridge, bridgeIndex);
                map = outputView.printMap(bridgeGame.bridgeU, bridgeGame.bridgeD);
                out_Of_Game = bridgeGame.retry(map);
                bridgeIndex++;
                i++;
            }
            roundCnt++;
            if (!out_Of_Game) {
                restart();
                success = "실패";
            }
            if (bridgeSize_Input == bridgeGame.bridgeU.size()) {
                success = "성공";
                outputView.printResult(success, roundCnt);
                break;
            }
        }
        if (!startGame) {
            outputView.printResult(success, roundCnt);
        }
    }

    private void start() {
        OutputForm.START_MESSAGE.printMessage();
        bridgeSize_Input = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize_Input);
    }

    private boolean restart() {
        bridgeGame.clearBridge();
        String restartOrQuit_Input = inputView.readGameCommand();
        startGame = bridgeGame.restartOrQuit(restartOrQuit_Input);
        return startGame;
    }

}

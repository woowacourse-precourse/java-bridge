package bridge;

import view.InputView;
import view.OutputView;

import java.util.List;

import static message.GameMessage.*;

public class GameManager {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame;
    List<String> bridge;
    String movingPosition;
    int totalTry = 0;
    boolean isSuccess = true;

    void play() {
        System.out.println(Starting.getMessage());
        makeBridge();
        run();
        outputView.printResult(bridgeGame.getBridgeMap(), totalTry, isSuccess);
    }

    void makeBridge() {
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }

    void run() {
        while(true) {
            totalTry++;
            if(moving())
                break;
            if(inputView.readGameCommand().equals("Q")) {
                isSuccess = false;
                break;
            }
            bridgeGame.retry();
        }
    }

    boolean moving() {
        for(int i = 0; i < bridge.size(); i++) {
            movingPosition = inputView.readMoving();
            boolean success = bridgeGame.move(movingPosition, i);
            outputView.printMap(bridgeGame.getBridgeMap());
            if(!success)
                return false;
        }
        return true;
    }
}

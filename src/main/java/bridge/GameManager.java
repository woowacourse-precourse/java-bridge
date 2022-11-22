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
    List<List<String>> bridgeMap;
    String movingPosition;

    void play() {
        System.out.println(Starting.getMessage());
        makeBridge();
        run();
    }

    void makeBridge() {
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
        init();
    }

    private void init() {
        List<String> initial = List.of("[","]");
        bridgeMap.add(0, initial);
        bridgeMap.add(1, initial);
    }

    void run() {
        while(true) {
            if(moving())
                break;
            if(inputView.readGameCommand().equals("Q"))
                break;
            bridgeGame.retry();
        }
        outputView.printResult();
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

package bridge.controller;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {
    private int bridgeLength;
    private int playCount = 0;
    public List<String> makedBridge = new ArrayList<>();

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    UserResult userResult;
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void play() {
        try {
            boolean gameSuccess = true;
            outputView.printStart();
            Bridge bridge = new Bridge(inputView.readBridgeSize());
            makedBridge = bridgeMaker.makeBridge(bridge.getBridgeLength());
            gameSuccess = oneGame(bridge);
            outputView.printResult(userResult, gameSuccess, playCount);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean oneGame(Bridge bridge) {
        boolean gameSuccess = true;
        do {
            playCount += 1;
            userResult = new UserResult();
            if (moveBridge(userResult ,bridge.getBridgeLength())) {
                break;
            }
            gameSuccess = bridgeGame.retry(inputView.readGameRetryCommand());
        }while(gameSuccess);
        return gameSuccess;
    }

    private boolean moveBridge(UserResult userResult ,int bridgeLength) {
        boolean success = true;
        for (int i=0; i<bridgeLength; i++) {
            success = bridgeGame.move(userResult, inputView.readMoving(), makedBridge.get(i));
            outputView.printMap(userResult);
            if (!success) {
                return success;
            }
        }
        return success;
    }
}

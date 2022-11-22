package bridge.controller;

import bridge.*;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private int bridgeLength;
    private int playCount = 0;
    private List<String> makedBridge;

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame = new BridgeGame();
    UserResult userResult;
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void play() {
        try {
            outputView.printStart();
            Bridge bridge = new Bridge(inputView.readBridgeSize());
            makedBridge = bridgeMaker.makeBridge(bridgeLength);
            do {
                userResult = new UserResult();
                if (moveBridge(bridge.getBridgeLength())) {
                    break;
                }
            }while(bridgeGame.retry(inputView.readGameRetryCommand()));
            outputView.printResult();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean moveBridge(int bridgeLength) {
        boolean success = true;
        for (int i=0; i<bridgeLength; i++) {
            success = bridgeGame.move(userResult, inputView.readMoving(), makedBridge.get(i));
            outputView.printMap();
            if (!success) {
                return success;
            }
        }
        return success;
    }
}

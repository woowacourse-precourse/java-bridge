package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import java.util.List;

public class BridgeGameController {

    private static List<String> bridge;
    private static int gameCount = 1;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
    }

    public void createBridge() {
        int bridgeSize = InputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void run(){
        int bridgeSize = bridge.size();
        boolean isMoveSuccess = true;
        for (int moveCount = 0; moveCount < bridgeSize; moveCount++) {
            String moving = InputView.readMoving();
            isMoveSuccess = bridgeGame.move(bridge, moving);
            if (!isMoveSuccess){
                bridgeGame.retry();
                break;
            }
        }
    }
}

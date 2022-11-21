package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.domain.MoveSpace;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    boolean successMoving = true;

    public void startGame() {

    }


    public void runGame() {
        BridgeGame bridgeGame = new BridgeGame();
        Bridge bridge = new Bridge(InputView.readBridgeSize());
        List<MoveResult> moveResult = new ArrayList<>();
        if (runMoving(bridgeGame, bridge, moveResult)){
            bridgeGame.retry();
        }
    }


    private boolean runMoving(BridgeGame bridgeGame, Bridge bridge, List<MoveResult> moveResult) {
        boolean movingFail = true;
        while (movingFail) {
            bridgeGame.move(moveResult, bridge);
            OutputView.printMap(moveResult);
            movingFail = bridge.getCurrentResult();
            if (bridge.stepCount == bridge.bridge.size()) {
                return false;
            }
        }
        return true;
    }
}

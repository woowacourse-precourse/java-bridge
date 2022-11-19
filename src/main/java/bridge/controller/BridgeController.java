package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.ResultFlag;
import bridge.domain.User;
import bridge.model.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.view.BridgeView;
import java.util.List;

public class BridgeController {
    private final BridgeView bridgeView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController(BridgeView bridgeView, BridgeMaker bridgeMaker) {
        this.bridgeView = bridgeView;
        this.bridgeMaker = bridgeMaker;
    }

    public void gameStart() {
        init();
        loop();
        bridgeView.printResult(bridgeGame.getMap(), bridgeGame.isCrossOver(), bridgeGame.getTryCount());
    }

    private void init() {
        bridgeView.printStartMessage();
        List<String> strings = bridgeMaker.makeBridge(bridgeView.receiveBridgeSize());
        bridgeGame = new BridgeGame(new User(), Bridge.of(strings));
    }

    private void loop() {
        while (true) {
            GameFlag flag = routine();
            if (flag == GameFlag.QUIT) {
                return;
            }
            if (flag == GameFlag.RESTART) {
                bridgeGame.retry();
            }
        }
    }

    private GameFlag routine() {
        bridgeGame.move(bridgeView.receiveMoving());
        bridgeView.printMap(bridgeGame.getMap());
        ResultFlag result = bridgeGame.isCrossOver();
        if (result == ResultFlag.SUCCESS) {
            return GameFlag.QUIT;
        }
        if (result == ResultFlag.FAIL) {
            return bridgeView.receiveRestart();
        }
        return GameFlag.NOTHING;
    }
}

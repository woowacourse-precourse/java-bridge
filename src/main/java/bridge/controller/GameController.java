package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private List<String> bridge;
    private List<String> upBridge;
    private List<String> downBridge;

    private int stage;

    public void init() {
        stage = inputView.readBridgeSize();
        outputView.printGameStart();
        bridge = bridgeMaker.makeBridge(stage);
    }

    public void addBridgeMove(String direction) {
        if (direction.equals("U")) {
            addUpMove(bridgeGame.move(bridge, direction, stage));
            return;
        }
        addDownMove(bridgeGame.move(bridge, direction, stage));
    }

    public void addUpMove(String move) {
        if (move.equals(" O ")) {
            upBridge.add(" O ");
            downBridge.add("   ");
            return;
        }
        upBridge.add(" X ");
        downBridge.add("   ");
    }

    public void addDownMove(String move) {
        if (move.equals(" O ")) {
            downBridge.add(" O ");
            upBridge.add("   ");
            return;
        }
        downBridge.add(" X ");
        upBridge.add("   ");
    }
}

package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.GameCommandFlag;
import bridge.model.ResultFlag;
import bridge.view.ConsolidatedView;

import java.util.List;

public class BridgeController {
    private final ConsolidatedView consolidatedView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController(ConsolidatedView consolidatedView, BridgeMaker bridgeMaker) {
        this.consolidatedView = consolidatedView;
        this.bridgeMaker = bridgeMaker;
    }

    public void startGame() {
        consolidatedView.printStartMessage();
        List<String> bridge = bridgeMaker.makeBridge(consolidatedView.inputBridgeSize());

    }

    private void playGame() {

    }

    private GameCommandFlag moveBridge() {
        bridgeGame.move(consolidatedView.inputMoving());
        consolidatedView.printMoveMap(bridgeGame.getMap());

    }
}

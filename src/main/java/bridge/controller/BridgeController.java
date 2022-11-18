package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.Map;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeController(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void run() {
        outputView.gameStart();
        Bridge bridge = createBridge();

        bridgeGame = new BridgeGame(bridge);
        movePlayer();
    }

    private Bridge createBridge() {
        outputView.inputBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private void movePlayer() {
        outputView.inputPlayerMove();
        Movement playerMove = inputView.readMoving();
        Map<Movement, List<String>> crossingResults = bridgeGame.move(playerMove);
        outputView.printMap(crossingResults);
    }
}

package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeShape;
import bridge.view.InputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void gameStart() {
        BridgeGame bridgeGame = new BridgeGame(createBridge());
        move(bridgeGame);
    }

    private Bridge createBridge() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeShapeValues = bridgeMaker.makeBridge(bridgeSize);
        return Bridge.createByBridgeShapeValue(bridgeShapeValues);
    }

    private void move(BridgeGame bridgeGame) {
        BridgeShape moveBridgeShape = BridgeShape.of(inputView.readMoving());
        bridgeGame.move(moveBridgeShape);
    }
}

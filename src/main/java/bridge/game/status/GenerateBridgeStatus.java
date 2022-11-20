package bridge.game.status;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.maker.BridgeMaker;
import bridge.domain.bridge.maker.BridgeRandomNumberGenerator;
import bridge.game.context.BridgeGameContext;
import bridge.view.BridgeGameView;

public class GenerateBridgeStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, BridgeGameView bridgeGameView) {
        var bridgeSize = bridgeGameView.getInputView()
                .readBridgeSize();

        var bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        var bridge = new Bridge(bridgeMaker, bridgeSize);

        context.generateBridge(bridge);
        return new PlayerUnitMoveStatus();
    }

    @Override
    public boolean runnable() {
        return true;
    }
}

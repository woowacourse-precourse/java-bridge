package bridge.game.status;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.maker.BridgeMaker;
import bridge.domain.bridge.maker.BridgeRandomNumberGenerator;
import bridge.game.context.BridgeGameContext;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GenerateBridgeStatus implements BridgeGameStatus {
    @Override
    public BridgeGameStatus next(BridgeGameContext context, InputView inputView, OutputView outputView) {
        var bridgeSize = inputView.readBridgeSize();

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

package bridge.engine;

import bridge.BridgeMaker;
import bridge.error.Error;
import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Crossing;
import bridge.model.PassOrFail;
import bridge.model.UpOrDown;
import java.util.Objects;

public class BridgeGameEngine {

    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;

    public BridgeGameEngine(BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }

    public Bridge makeBridge(int userInputSize) {
        BridgeSize bridgeSize = new BridgeSize(userInputSize);
        int size = bridgeSize.getValue();

        return new Bridge(bridgeMaker.makeBridge(size));
    }

    public void cross(Crossing crossing, Bridge bridge, UpOrDown upOrDown) {
        if (Objects.isNull(crossing) || Objects.isNull(bridge) || Objects.isNull(upOrDown)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        int nextStep = crossing.getNextStep();
        PassOrFail passOrFail = new PassOrFail(bridge.isCross(nextStep, upOrDown));

        bridgeGame.move(crossing, passOrFail);
    }
}

package bridge.engine;

import bridge.BridgeMaker;
import bridge.error.Error;
import bridge.model.Bridge;
import bridge.model.BridgeSize;
import bridge.model.Crossing;
import bridge.model.PassOrFail;
import bridge.model.UpOrDown;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        List<UpOrDown> bridge = bridgeMaker.makeBridge(size).stream()
                .map(v -> new UpOrDown(v))
                .collect(Collectors.toList());

        return new Bridge(bridge);
    }

    public void cross(Crossing crossing, Bridge bridge, UpOrDown upOrDown) {
        if (Objects.isNull(crossing) || Objects.isNull(bridge) || Objects.isNull(upOrDown)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        int nextStep = crossing.getNextStep();
        boolean crossed = bridge.isToCrossed(nextStep, upOrDown);
        PassOrFail passOrFail = new PassOrFail(crossed, upOrDown);

        bridgeGame.move(crossing, passOrFail);
    }
}

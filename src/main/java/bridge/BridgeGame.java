package bridge;

import bridge.domain.BridgeLength;
import bridge.domain.BridgeStatus;
import bridge.domain.MovingCommand;
import bridge.domain.RetryCommand;
import java.util.List;

public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final BridgeStatusSaver bridgeStatusSaver;

    public BridgeGame(BridgeMaker bridgeMaker, BridgeStatusSaver bridgeStatusSaver) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeStatusSaver = bridgeStatusSaver;
    }

    public void createBridge(BridgeLength bridgeLength) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength.intValue());
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);
        bridgeStatusSaver.setBridgeStatus(bridgeStatus);
    }

    public BridgeStatus move(MovingCommand movingCommand) {
        BridgeStatus bridgeStatus = bridgeStatusSaver.getBridgeStatus();
        bridgeStatus.addUserMovingCommand(movingCommand);
        bridgeStatusSaver.setBridgeStatus(bridgeStatus);
        return bridgeStatus;
    }

    public boolean retry(RetryCommand retryCommand) {
        if (retryCommand.equals(RetryCommand.RETRY)) {
            BridgeStatus bridgeStatus = bridgeStatusSaver.getBridgeStatus();
            bridgeStatus.clearUserBridge();
            bridgeStatus.addTryCount();
            bridgeStatusSaver.setBridgeStatus(bridgeStatus);
            return true;
        }
        return false;
    }
}

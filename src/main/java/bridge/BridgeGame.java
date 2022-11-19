package bridge;

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

    public void createBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeStatus bridgeStatus = BridgeStatus.createBridgeStatus(bridge);
        bridgeStatusSaver.setBridgeStatus(bridgeStatus);
    }

    public BridgeStatus move(String input) {
        MovingCommand movingCommand = MovingCommand.nameOf(input);
        BridgeStatus bridgeStatus = bridgeStatusSaver.getBridgeStatus();
        bridgeStatus.addUserMovingCommand(movingCommand);
        bridgeStatusSaver.setBridgeStatus(bridgeStatus);
        return bridgeStatus;
    }

    public boolean retry(String input) {
        RetryCommand retryCommand = RetryCommand.nameOf(input);
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

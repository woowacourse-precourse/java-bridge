package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import bridge.util.TypeConverter;
import bridge.validate.ValidateInput;

import java.util.List;
import java.util.Objects;

public class BridgeGame {

    private final User user;
    private final Bridge bridge;

    public BridgeGame() {
        this.user = new User();
        this.bridge = new Bridge();
        start();
    }

    public void start() {
        int bridgeSize = bridge.getBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        processCrossingBridge(bridge);

        while (!user.isRestartGame()) {
            retry(bridge);
        }
    }

    private void processCrossingBridge(List<String> bridge) {
        for (int step = 0; step < bridge.size(); step++) {
            String movingBlock = this.bridge.selectBlock();
            user.currentBlock = TypeConverter.blockToNumber(movingBlock);
            if (isFailed(step, bridge, movingBlock)) {
                break;
            }
        }
    }

    private boolean isFailed(int step, List<String> bridge, String movingBlock) {
        return user.changeStatusIsFailed(move(step, bridge, movingBlock));
    }

    private boolean move(int step, List<String> bridge, String movingBlock) {
        user.addBridgeInfo(step, movingBlock);
        if (Objects.equals(bridge.get(step), movingBlock)) {
            this.bridge.printingBridge(true, user, step);
            return true;
        }
        this.bridge.printingBridge(false, user, step);
        return false;
    }

    private void retry(List<String> bridge) {
        String restartGameWhether = user.readGameCommand();
        ValidateInput.validateRestartGameWhether(restartGameWhether);

        if (user.ifUserInputQStopGameOrElseRestart(restartGameWhether)) {
            processCrossingBridge(bridge);
        }
    }

    public void printResult() {
        System.out.println();
        user.printResult();
    }
}

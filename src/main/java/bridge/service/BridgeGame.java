package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.User;
import bridge.util.TypeConverter;
import bridge.validate.ValidateInput;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Objects;

public class BridgeGame {

    private final User user;

    public BridgeGame() {
        this.user = new User();
        start();
    }

    public void start() {
        OutputView.printStartBridgeGame();
        int bridgeSize = InputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        processCrossingBridge(bridge);

        while (!user.isRestartGame()) {
            retry(bridge);
        }
    }

    private void processCrossingBridge(List<String> bridge) {
        for (int step = 0; step < bridge.size(); step++) {
            String movingBlock = OutputView.printSelectMovingBlock();
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
            OutputView.printMap(true, user, step);
            return true;
        }
        OutputView.printMap(false, user, step);
        return false;
    }

    private void retry(List<String> bridge) {
        String restartGameWhether = InputView.readGameCommand();
        ValidateInput.validateRestartGameWhether(restartGameWhether);
    }
}

package bridge.domain;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Bridge {

    public int getBridgeSize() {
        OutputView.printStartBridgeGame();
        return InputView.readBridgeSize();
    }

    public void printingBridge(boolean isSuccess, User user, int step) {
        OutputView.printMap(isSuccess, user, step);
    }

    public String selectBlock() {
        return OutputView.printSelectMovingBlock();
    }
}

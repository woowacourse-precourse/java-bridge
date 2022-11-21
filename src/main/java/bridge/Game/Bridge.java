package bridge.Game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Utils.Comparator;
import bridge.View.InputView;

import java.util.List;

public class Bridge extends BridgeMaker {
    private final InputView userView;
    private final Comparator comparator;
    private final List<String> bridge;

    public Bridge() {
        super(new BridgeRandomNumberGenerator());
        this.userView = new InputView();
        this.comparator = new Comparator();

        int size = userView.readBridgeSize();
        this.bridge = makeBridge(size);
    }

    public boolean passBridge() {
        String direction = userView.readMoving();
        boolean passResult = comparator.passBlockAndResult(bridge, direction);

        List<String> passedBridge = comparator.getPassedBridge(bridge);
        userView.printMap(passedBridge, direction, passResult);

        return passResult;
    }

    public boolean retryPassBridge() {
        String retryInput = userView.readGameCommand();

        if (retryInput.equals("R")) {
            comparator.addTryCount();
            return true;
        }

        return false;
    }

    public boolean isNotArrived() {
        return comparator.isPassable(bridge);
    }

    public void showResult() {
        userView.printResult(isNotArrived(), comparator.getTryCount());
    }

}

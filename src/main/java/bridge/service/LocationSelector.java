package bridge.service;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

public class LocationSelector {

    public static String selectMoveTo(Bridge bridge) {
        OutputView.notifySelectMoveLocation();
        String moveTo = InputView.readMoving();
        bridge.addResult(moveTo);
        OutputView.printMap(bridge);
        return moveTo;
    }

}

package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<String> route = new ArrayList<>();
    private int attemptNum = 1;
    private int location = -1;
    private Status status = Status.DOING;
    private final Bridge bridge;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    User() {
        this.bridge = new Bridge(inputView.readBridgeSize(), new BridgeRandomNumberGenerator());
    }

    private boolean isCrossBridge() {
        if (location == bridge.size() - 1) {
            status = Status.SUCCESS_END;
            return true;
        }
        return false;
    }

}

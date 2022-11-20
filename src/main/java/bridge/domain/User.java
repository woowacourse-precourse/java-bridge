package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<String> route = new ArrayList<>();
    private int attemptNum = 1;
    private int location = -1;
    private int bridgeSize;
    private Status status = Status.DOING;
    private final Bridge bridge;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    User() {
        this.bridgeSize = inputView.readBridgeSize();
        this.bridge = new Bridge(this.bridgeSize, new BridgeRandomNumberGenerator());
    }

    private boolean isCrossBridge() {
        return location == bridgeSize - 1;
    }

}

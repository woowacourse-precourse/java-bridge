package bridge.domain;

import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<String> route = new ArrayList<>();
    private int attemptNum = 1;
    private int location = -1;
    private int bridgeSize;
    private Status status = Status.DOING;
    private Bridge bridge;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    User(){
        this.bridgeSize = inputView.readBridgeSize();
        this.bridge = new Bridge(this.bridgeSize,new BridgeRandomNumberGenerator());
    }

}

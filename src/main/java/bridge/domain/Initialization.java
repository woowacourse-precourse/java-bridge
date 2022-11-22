package bridge.domain;

import bridge.Application;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Initialization {

    public static int init() {
        OutputView.printStart();
        OutputView.printRequestSize();
        int size = InputView.readBridgeSize();
        Application.totalTrial = 1;
        return size;
    }

}

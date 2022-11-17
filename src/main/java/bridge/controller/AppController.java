package bridge.controller;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

public class AppController {
    //private final Bridge bridge;

    public void makeBridge() {
        OutputView.printLine(Message.INTRO);
        OutputView.printLine("");
        OutputView.printLine(Message.INQUIRE_BRIDGE_LENGTH);
        int length = InputView.readBridgeSize();
    }

    public void acrossBridge() {

    }

    public void showResult() {

    }

    public void run() {
        makeBridge();
        acrossBridge();
        showResult();
    }
}

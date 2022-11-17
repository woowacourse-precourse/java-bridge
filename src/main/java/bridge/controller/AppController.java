package bridge.controller;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

public class AppController {
    private Bridge bridge;

    public void makeBridge() {
        OutputView.printLine(Message.INTRO);
        OutputView.printLine("");
        OutputView.printLine(Message.INQUIRE_BRIDGE_LENGTH);
        int size = InputView.readBridgeSize();
        BridgeController.setBridgeInstance(bridge, size);
        OutputView.printLine("");
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

package bridge.controller;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.Message;
import bridge.view.OutputView;

public class AppController {
    BridgeGame game;

    public void makeBridge() {
        OutputView.printLine(Message.INTRO);
        OutputView.printLine("");
        OutputView.printLine(Message.INQUIRE_BRIDGE_LENGTH);
        int size = InputView.readBridgeSize();
        game = new BridgeGame(size);
        OutputView.printLine("");
    }

    public void acrossBridge() {
        OutputView.printLine(Message.INQUIRE_MOVE_BLOCK);

    }

    public void oneTry() {

    }

    public void showResult() {

    }

    public void run() {
        makeBridge();
        acrossBridge();
        showResult();
    }
}

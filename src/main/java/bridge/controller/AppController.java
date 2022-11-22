package bridge.controller;

import bridge.constant.MessageOutput;
import bridge.view.InputView;
import bridge.view.OutputView;

public class AppController {
    BridgeGame bridgeGame;

    void makeBridge() {
        OutputView.printLine(MessageOutput.INTRO);
        OutputView.printLine("");
        OutputView.printLine(MessageOutput.INQUIRE_BRIDGE_LENGTH);
        int size = InputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);
        OutputView.printLine("");
    }

    void crossOver() {

    }

    void showResult() {

    }

    public void run() {
        makeBridge();
        crossOver();
        showResult();
    }
}

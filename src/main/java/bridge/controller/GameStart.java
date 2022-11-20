package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameStart {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static Bridge gameStart(BridgeMaker bridgeMaker) {
        outputView.printStart();
        while (true) {
            try {
                return new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

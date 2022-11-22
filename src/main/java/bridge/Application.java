package bridge;

import bridge.controller.Controller;
import bridge.view.InputView;
import bridge.view.InputViewRetryProxy;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        new Controller(
                new InputViewRetryProxy(new InputView()),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator())
        ).start();
    }
}

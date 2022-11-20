package bridge;

import bridge.io.InputView;
import bridge.io.OutputView;

public class Application {

    public static void main(String[] args) {
        new BridgeProgram(
                new InputView(),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator()),
                new BridgeGame())
                .run();
    }
}

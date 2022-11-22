package bridge;

import bridge.model.BridgeGame;
import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.model.BridgeMaker;

public class Application {

    public static void main(String[] args) {
        new BridgeGameProgram(
                new InputView(),
                new OutputView(),
                new BridgeMaker(new BridgeRandomNumberGenerator()),
                new BridgeGame())
                .run();
    }
}

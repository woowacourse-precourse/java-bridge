package bridge;

import bridge.ui.input.InputView;
import bridge.ui.output.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameConsole bridgeGameConsole = new BridgeGameConsole(inputView, outputView);
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();

        bridgeGameConsole.launchGame(generator);
    }
}

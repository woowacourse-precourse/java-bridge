package bridge;

import bridge.view.InputParser;
import bridge.view.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputFormatter;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView(new InputValidator(), new InputParser());
        OutputView outputView = new OutputView(new OutputFormatter());

        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine(inputView, outputView);
        bridgeGameMachine.play();
    }
}

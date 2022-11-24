package bridge;

import bridge.service.BridgeGameService;
import bridge.view.InputParser;
import bridge.view.InputValidator;
import bridge.view.InputView;
import bridge.view.OutputFormatter;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = inputView();
        OutputView outputView = outputView();
        BridgeGameService bridgeGameService = bridgeGameService();

        BridgeGameMachine bridgeGameMachine = new BridgeGameMachine(inputView, outputView,
                bridgeGameService);
        bridgeGameMachine.play();
    }

    private static InputView inputView() {
        return new InputView(new InputValidator(), new InputParser());
    }

    private static OutputView outputView() {
        return new OutputView(new OutputFormatter());
    }

    private static BridgeGameService bridgeGameService() {
        return new BridgeGameService(
                new BridgeMaker(new BridgeRandomNumberGenerator()));
    }
}

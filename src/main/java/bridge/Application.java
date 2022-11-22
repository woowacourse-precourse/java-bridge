package bridge;

import bridge.io.InputView;
import bridge.io.OutputView;
import bridge.validation.InputValidator;
import bridge.validation.InputValidatorImpl;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeChecker bridgeChecker = new BridgeChecker();
        InputValidator inputValidator = new InputValidatorImpl();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView(bridgeChecker);
        BridgeGame bridgeGame = new BridgeGame(bridgeChecker ,bridgeMaker);

        BridgeGameHost bridgeGameHost = new BridgeGameHost(inputView, outputView, bridgeGame);
        bridgeGameHost.runGame();
    }
}

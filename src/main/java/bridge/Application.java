package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.BridgeClientConsole;
import bridge.view.ClientConsole;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        ClientConsole clientConsole = new BridgeClientConsole();
        InputView inputView = new InputView(clientConsole);
        OutputView outputView = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        BridgeGameRunner bridgeGameRunner = new BridgeGameRunner(
            new BridgeController(inputView, outputView, bridgeGame));

        bridgeGameRunner.run();
    }
}

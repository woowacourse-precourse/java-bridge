package bridge.controller;

import static bridge.controller.InputController.getBridgeSize;
import static bridge.controller.InputController.getGameCommand;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Diagram;
import bridge.model.FinalResult;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();


    public void play() {

        outputView.printStartGame();

        Bridge bridge = createBridge();

        FinalResult finalResult = new FinalResult();
        Diagram diagram = new Diagram();

        BridgeGame bridgegame = new BridgeGame(bridge, diagram, finalResult);

        while (bridgegame.retry()) {
            bridgegame.move();
            if (finalResult.isSuccess()) {
                outputView.printResult(diagram, finalResult);
            }
            if (!finalResult.isSuccess()) {
                String retryOrQuit = getGameCommand();
                if (retryOrQuit.equals("R")) {
                    finalResult.addAttempts();
                    diagram = new Diagram();
                }
                if (retryOrQuit.equals("Q")) {
                    finalResult.quit();
                }
            }
        }
    }

    private static Bridge createBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(getBridgeSize()));
        return bridge;
    }
}

package bridge.controller;

import bridge.*;
import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private BridgeGame bridgeGame;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        Bridge bridge = createBridge();
        bridgeGame = new BridgeGame(bridge);
        runGame();
    }

    Bridge createBridge() {
        String inputSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        if (!bridgeMaker.validateBridgeSize(inputSize))
            return createBridge();

        List<String> bridgeAnswer = bridgeMaker.makeBridge(Integer.parseInt(inputSize));
        return new Bridge(bridgeAnswer);
    }

    void runGame() {
        while (true) {
            crossBridge();
            if (isAnswer())
                break;
            if (bridgeGame.checkSuccess())
                break;
        }
        outputView.printResult(bridgeGame);
    }

    void crossBridge() {
        String movement = inputMovement();
        bridgeGame.move(movement);
        outputView.printMap(bridgeGame.getBridgeMap());
    }

    String inputMovement() {
        String movement = inputView.readMoving();
        if (!bridgeGame.validateMoving(movement)) {
            return inputMovement();
        }
        return movement;
    }

    boolean isAnswer() {
        if (!bridgeGame.getIsAnswer())
            return inputCommand();
        return false;
    }

    boolean inputCommand() {
        String command = inputView.readGameCommand();
        if (!bridgeGame.validateGameCommand(command))
            return inputCommand();
        return bridgeGame.isExit(command);
    }
}

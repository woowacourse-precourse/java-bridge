package bridge.controller;

import bridge.*;
import bridge.Model.Bridge;
import bridge.Model.BridgeGame;
import bridge.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
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
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        if(!bridgeMaker.validateBridgeSize(inputSize)){
            return createBridge();
        }
        int bridgeSize = Integer.parseInt(inputSize);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeAnswer);
    }

    void runGame() {
        while (true) {
            String movement = inputMovement();
            bridgeGame.move(movement);
            outputView.printMap(bridgeGame.getBridgeMap());
            if (isAnswer())
                break;
            if (bridgeGame.checkSuccess())
                break;
        }
        outputView.printResult(bridgeGame);
    }

    String inputMovement() {
        String movement = inputView.readMoving();
        if(!bridgeGame.validateMoving(movement)){
            return inputMovement();
        }
        return movement;
    }

    boolean isAnswer() {
        if (!bridgeGame.getIsAnswer()) {
            String command = inputView.readGameCommand();
            return bridgeGame.isExit(command);
        }
        return false;
    }
}

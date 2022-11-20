package bridge;

import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private Bridge bridge;
    private BridgeGame bridgeGame;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();

    }

    void run() {
        bridge = createBridge();
        bridgeGame = new BridgeGame(bridge);
        runGame();
        outputView.printResult(bridgeGame);
    }

    Bridge createBridge() {
        int bridgeSize = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridgeAnswer = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeAnswer);
    }

    void runGame() {
        while (true) {
            inputMovement();
            outputView.printMap(bridgeGame.getBridgeMap());
            if (isAnswer())
                break;
            if (bridgeGame.checkSuccess())
                break;
        }
    }

    void inputMovement() {
        String movement = inputView.readMoving();
        bridgeGame.move(movement);
    }

    boolean isAnswer() {
        if (!bridgeGame.getIsAnswer()) {
            String command = inputView.readGameCommand();
            return bridgeGame.isExit(command);
        }
        return false;
    }
}

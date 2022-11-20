package controller;

import bridge.*;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Bridge bridge = createBridge();
        bridge.print();
        move(bridge);
    }

    private Bridge createBridge() {
        outputView.printGameStart();

        BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private void move(Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        String gameCommand = "";
        boolean isCorrect;

        do {
            String movingPlace = inputView.readMoving();
            isCorrect = bridgeGame.move(movingPlace);
            outputView.printMap(bridge.toString());
            if (!isCorrect) {
                gameCommand = inputView.readGameCommand();
            }
        } while (isRetry(gameCommand, isCorrect));
    }

    private boolean isRetry(String gameCommand, boolean isCorrect) {
        if (gameCommand.equals("Q")) {
            return false;
        }

        return gameCommand.equals("R") && !isCorrect;
    }

}

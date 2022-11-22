package controller;

import bridge.*;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Bridge bridge = createBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        gameStart(bridge, bridgeGame);
        outputView.printResult(bridgeGame, bridge.toString());
    }

    private Bridge createBridge() {
        outputView.printGameStart();

        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private void gameStart(Bridge bridge, BridgeGame bridgeGame) {
        boolean isQuit;

        do {
            isQuit = onePlaceMove(bridge, bridgeGame);
        } while (bridgeGame.gameContinue(bridge, isQuit));
    }

    private boolean onePlaceMove(Bridge bridge, BridgeGame bridgeGame) {
        String gameCommand;
        boolean isCorrect;

        do {
            isCorrect = move(bridge, bridgeGame);
            gameCommand = getGameCommand(isCorrect);
        } while (bridgeGame.isRetry(gameCommand, isCorrect));

        return bridgeGame.isQuit(gameCommand);
    }

    private boolean move(Bridge bridge, BridgeGame bridgeGame) {
        boolean isCorrect;

        String movingPlace = inputView.readMoving();
        isCorrect = bridgeGame.move(movingPlace);
        outputView.printMap(bridge.toString());

        return isCorrect;
    }

    private String getGameCommand(boolean isCorrect) {
        if (!isCorrect) {
            return inputView.readGameCommand();
        }
        return "";
    }
}
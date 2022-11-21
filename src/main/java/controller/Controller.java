package controller;

import bridge.*;
import utils.ConstValue;
import view.InputView;
import view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Bridge bridge = createBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean isQuit;

        do {
            isQuit = onePlaceMove(bridge, bridgeGame);
        } while (gameContinue(bridge, isQuit));

        outputView.printResult(bridgeGame, bridge.toString());
    }

    private Bridge createBridge() {
        outputView.printGameStart();

        BridgeNumberGenerator BridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(BridgeRandomNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private boolean onePlaceMove(Bridge bridge, BridgeGame bridgeGame) {
        String gameCommand;
        boolean isCorrect;

        do {
            isCorrect = move(bridge, bridgeGame);
            gameCommand = getGameCommand(isCorrect);
        } while (isRetry(gameCommand, isCorrect, bridgeGame));

        return isQuit(gameCommand);
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

    private boolean isRetry(String gameCommand, boolean isCorrect, BridgeGame bridgeGame) {
        if (gameCommand.equals(ConstValue.RETRY)) {
            bridgeGame.retry();
        }

        return gameCommand.equals(ConstValue.RETRY) && !isCorrect;
    }

    private boolean isQuit(String gameCommand) {
        return gameCommand.equals(ConstValue.QUIT);
    }

    private boolean gameContinue(Bridge bridge, boolean isQuit) {
        return !bridge.isCompleted() && !isQuit;
    }
}
package bridge.controller;

import bridge.domain.Bridge;
import bridge.game.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void executeGame() {
        outputView.printOpening();
        bridgeGame = new BridgeGame(makeBridge());
        crossToOtherSide();
        printFinalResult();
    }

    private Bridge makeBridge() {
        outputView.printBrideSizeOpening();
        int bridgeSize;
        try {
            bridgeSize = inputView.readBridgeSize(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return makeBridge();
        }
        outputView.printEmptyLine();
        return new Bridge(bridgeSize);
    }

    private void crossToOtherSide() {
        while (!bridgeGame.playerHasCrossed() && bridgeGame.onPlay()) {
            outputView.printUserChoiceOpening();
            try {
                String choice = inputView.readMoving(inputView.userInput());
                moveNextStep(choice);
                updateGameStatus(bridgeGame.isLastMoveSuccess());
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void moveNextStep(String choice) {
        bridgeGame.move(choice);
        outputView.printMap(bridgeGame.matchResults(), bridgeGame.getPlayersMove());
    }

    private void updateGameStatus(boolean success) {
        if (!success) {
            outputView.printGameContinueOpening();
            try {
                String cmd = inputView.readGameCommand(inputView.userInput());
                bridgeGame.transitionTo(cmd);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
                updateGameStatus(success);
            }
        }
    }

    private void printFinalResult() {
        outputView.printResultOpening();
        outputView.printMap(bridgeGame.matchResults(), bridgeGame.getPlayersMove());
        outputView.printResult(bridgeGame.getContextInfo());
    }
}

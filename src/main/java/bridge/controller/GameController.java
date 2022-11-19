package bridge.controller;

import bridge.domain.Bridge;
import bridge.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class GameController {
    private static final String CONTINUE = "R";
    private static final String QUIT = "Q";

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
        // printFinalResult();
    }

    private Bridge makeBridge() {
        outputView.printBrideSizeOpening();
        int bridgeSize = 0;
        try {
            bridgeSize = inputView.readBridgeSize(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            makeBridge();
        }
        outputView.printEmptyLine();
        return new Bridge(bridgeSize);
    }

    private void crossToOtherSide() {
        while (!bridgeGame.playerHasCrossed()) {
            outputView.printUserChoiceOpening();
            try {
                String choice = inputView.readMoving(inputView.userInput());
                bridgeGame.move(choice);
                outputView.printMap(bridgeGame.matchResults(), bridgeGame.getPlayersMove());
                continueOrQuitIfFailed(bridgeGame.lastMoveMatches());
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }

    private void continueOrQuitIfFailed(boolean success) {
        if (!success) {
            outputView.printGameContinueOpening();
            try {
                String cmd = inputView.readGameCommand(inputView.userInput());
                decideNextStep(cmd);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
                continueOrQuitIfFailed(success);
            }

        }
    }

    private void decideNextStep(String cmd) {
        if (cmd.equals(CONTINUE)) {
            bridgeGame.retry();
            crossToOtherSide();
        }
        // printFinalResult();
    }
}

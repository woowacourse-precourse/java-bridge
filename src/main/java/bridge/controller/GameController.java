package bridge.controller;

import static bridge.domain.BridgeConstants.QUIT;
import static bridge.domain.BridgeConstants.RETRY;

import bridge.GameContext;
import bridge.domain.Bridge;
import bridge.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private final GameContext context;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        context = GameContext.getInstance();
    }

    public void executeGame() {
        outputView.printOpening();
        bridgeGame = new BridgeGame(makeBridge());
        crossToOtherSide();
        if (!context.hasQuit()){
            printFinalResult();
        }
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
        while (!bridgeGame.playerHasCrossed() && !context.hasQuit()) {
            outputView.printUserChoiceOpening();
            try {
                String choice = inputView.readMoving(inputView.userInput());
                moveNextStep(choice);
                retryOrQuitIfFailed(bridgeGame.lastMoveMatches());
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
        context.transition();
    }

    private void moveNextStep(String choice) {
        bridgeGame.move(choice);
        outputView.printMap(bridgeGame.matchResults(), bridgeGame.getPlayersMove());
    }

    private void retryOrQuitIfFailed(boolean success) {
        if (!success) {
            outputView.printGameContinueOpening();
            try {
                String cmd = inputView.readGameCommand(inputView.userInput());
                decideAction(cmd);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
                retryOrQuitIfFailed(success);
            }

        }
    }

    private void decideAction(String cmd) {
        if (cmd.equals(RETRY)) {
            context.increaseTryCount();
            bridgeGame.retry();
            crossToOtherSide();
        }
        if (cmd.equals(QUIT)) {
            context.quit();
            printFinalResult();
        }
    }

    private void printFinalResult() {
        outputView.printResultOpening();
        outputView.printMap(bridgeGame.matchResults(), bridgeGame.getPlayersMove());
        outputView.printResult(context.getTryCount(), context.isSuccess());
    }
}

package bridge;

import bridge.service.Service;
import bridge.utils.enums.GameState;
import bridge.utils.enums.RetryFormat;
import bridge.utils.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private final Service service = new Service();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        printGameStartMessage();
        setGame();
        playGame();
        finishGame();
    }

    private void printGameStartMessage() {
        outputView.printGameStartMessage();
    }

    private void setGame() {
        try {
            String bridgeSizeInput = inputView.readBridgeSize();
            service.prepareGame(bridgeSizeInput);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            setGame();
        }
    }

    private void playGame() {
        move();
        String playResult = service.getPlayResult();
        proceedDependsOnResult(playResult);
    }

    private void finishGame() {
        outputView.printFinalMessage();
        printMoveResult();
        List<String> finalResult = service.getFinalResult();
        outputView.printResult(finalResult);
    }

    private void move() {
        try {
            String moveInput = inputView.readMoving();
            service.move(moveInput);
            printMoveResult();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            move();
        }
    }

    private void printMoveResult() {
        List<String> currentResult = service.getCurrentResult();
        outputView.printMap(currentResult);
    }

    private void proceedDependsOnResult(String playResult) {
        if (GameState.LOOSE.isEqual(playResult)) {
            decideRetry();
        }

        if (GameState.PLAYING.isEqual(playResult)) {
            playGame();
        }
    }

    private void decideRetry() {
        String retryInput = requestRetryInput();
        if (RetryFormat.RETRY.isEqual(retryInput)) {
            retry();
        }
    }

    private String requestRetryInput() {
        try {
            String retryInput = inputView.readGameCommand();
            Validator.checkRetryInput(retryInput);
            return retryInput;
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return requestRetryInput();
        }
    }

    private void retry() {
        service.resetForRetry();
        playGame();
    }
}

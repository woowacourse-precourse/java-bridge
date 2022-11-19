package bridge;

import bridge.service.Service;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    Service service = new Service();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        printGameStartMessage();
        setGame();
        playGame();
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
        boolean moveSuccess = checkMoveSuccess();
        boolean gameEnd = checkGameEnd();

        if (moveSuccess && gameEnd) {
            printFinalResult();
        }

        if (moveSuccess && !gameEnd) {
            playGame();
        }

//        if (!moveSuccess) {
//            // requestRetryInput
//        }
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

    private boolean checkMoveSuccess() {
        return service.checkMoveSuccess();
    }

    private boolean checkGameEnd() {
        return service.isFinishedGame();
    }

    private void printFinalResult() {
        outputView.printFinalMessage();
        printMoveResult();
        List<String> finalResult = service.getFinalResult();
        outputView.printResult(finalResult);
    }
}

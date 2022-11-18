package bridge;

import bridge.service.Service;
import bridge.view.InputView;
import bridge.view.OutputView;

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
//            printMoveResult();
//            boolean gameEnd = checkGameEnd();
//            if(gameEnd) {
//                boolean gameWin = checkWinning();
//                if(gameWin) {
//                    printFinalResult();
//                }
//
//                if(!gameWin) {
//                    String retryInput = askRetry();
//                    if(retryInput.equals("R")) {
//                        resetGame();
//                        playGame();
//                    }
//
//                    if(retryInput.equals("Q")) {
//                        printFinalResult();
//                    }
//                }
//            }
//            if(!gameEnd) {
//                playGame();
//            }
    }

    private void move() {
        try {
            String moveInput = inputView.readMoving();
            service.move(moveInput);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            move();
        }
    }
}

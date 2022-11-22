package bridge;

import bridge.response.GameException;
import bridge.response.UserInputException;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static BridgeGame game;
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        game = new BridgeGame();
        try {
            outputView.printGameStartMessage();
            start();
        } catch (UserInputException inputException) {
            System.out.println(inputException.getMessage());
        } catch (GameException gameException) {
        }
    }

    private static void start() {
        game.trialCount++;
        gameInitProcess();
        checkMovementExceptionAndRun();
        gameProcess();
    }

    private static void gameInitProcess() {
        int bridgeSize = 0;
        try {
            bridgeSize = getBridgeSize();
            game.initBridge(bridgeSize);
        } catch (UserInputException bridgeSizeException) {
            outputView.printUserInputExceptionMessage(bridgeSizeException);
            gameInitProcess();
        }
    }

    private static void checkMovementExceptionAndRun() {
        try {
            gameProcess();
        } catch (UserInputException userInputException) {
            outputView.printUserInputExceptionMessage(userInputException);
            gameProcess();
        }
    }

    private static void gameProcess() {
        outputView.printMovementRequestMessage();
        String movement = inputView.readMoving();

        checkGameStatus(movement);

        outputView.printMap(game);
        gameProcess();
    }

    private static void checkGameStatus(String movement) {
        if (!game.move(movement)) {
            outputView.printMap(game);
            checkExitCodeExceptionAndRun();
        }

        if (game.userInput.size() == game.bridge.size()) {
            outputView.printMap(game);
            outputView.printResult(game, true);
            throw new GameException();
        }
    }

    private static void gameCommandProcess() {
        outputView.printExitCodeRequestMessage();
        String exitCode = inputView.readGameCommand();
        if (exitCode.equals("R")) {
            resetProcess();
            return;
        }

        quitProcess();
    }

    private static void checkExitCodeExceptionAndRun() {
        try {
            gameCommandProcess();
        } catch (UserInputException userInputException) {
            outputView.printUserInputExceptionMessage(userInputException);
            gameCommandProcess();
        }
    }

    private static void resetProcess() {
        game.retry();
        gameProcess();
    }

    private static void quitProcess() {
        outputView.printResult(game, false);
        throw new GameException();
    }


    private static int getBridgeSize() {
        outputView.printBridgeSizeRequestMessage();
        return inputView.readBridgeSize();
    }

}

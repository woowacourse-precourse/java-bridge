package bridge;

import response.GameException;
import response.UserInputException;
import view.InputView;
import view.OutputView;

public class Application {

    private static BridgeGame game = new BridgeGame();
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
//            startGame();
            start();
//            List<String> answerBridge = Arrays.asList("U", "D", "D");
//            List<String> userBridge = Arrays.asList("U", "D", "U");
//
//            outputView.printMap(answerBridge, userBridge);

        } catch (UserInputException inputException) {
            System.out.println(inputException.getMessage());
        } catch (GameException gameException) {
        }
    }

    private static void start() {
        game.trialCount++;
        gameInitProcess();
        gameProcess();
    }

    private static void gameInitProcess() {
        outputView.printGameStartMessage();
        int bridgeSize = getBridgeSize();
        game.initBridge(bridgeSize);
    }

    private static void gameProcess() {
        outputView.printMovementRequestMessage();
        String movement = inputView.readMoving();

        checkGameStatus(movement);

        outputView.printMap(game.bridge, game.userInput);
        System.out.println();
        gameProcess();
    }

    private static void checkGameStatus(String movement) {
        if (!game.move(movement)) {
            outputView.printMap(game.bridge, game.userInput);
            System.out.println();
            gameCommandProcess();
        }

        if (game.userInput.size() == game.bridge.size()) {
            outputView.printMap(game.bridge, game.userInput);
            System.out.println();
            outputView.printResult(game.bridge, game.userInput, true, game.trialCount);
            System.out.println();
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

    private static void resetProcess() {
        game.retry();
        gameProcess();
    }

    private static void quitProcess() {
        outputView.printResult(game.bridge, game.userInput, false, game.trialCount);
        throw new GameException();
    }


    private static int getBridgeSize() {
        outputView.printBridgeSizeRequestMessage();
        return inputView.readBridgeSize();
    }

}

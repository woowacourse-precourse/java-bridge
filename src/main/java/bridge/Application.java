package bridge;

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
        } catch (IllegalStateException e) {

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

        if (!game.move(movement)) {
            outputView.printMap(game.bridge, game.userInput);
            gameCommandProcess();
        }

        if (game.userInput.size() == game.bridge.size()) {
            outputView.printResult(game.bridge, game.userInput, true, game.trialCount);
            throw new IllegalStateException();
        }

        outputView.printMap(game.bridge, game.userInput);
        gameProcess();
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
        throw new IllegalStateException();
    }


    private static int getBridgeSize() {
        outputView.printBridgeSizeRequestMessage();
        return inputView.readBridgeSize();
    }

}

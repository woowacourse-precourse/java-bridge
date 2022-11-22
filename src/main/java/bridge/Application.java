package bridge;

public class Application {

    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        outputView.printStartMessage();

        try {
            game();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return;
        }
    }

    private static void game() {
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        System.out.println(bridgeGame.getRealBridge());
        while (true) {
            if (!runStage()) {
                break;
            }
        }
    }

    private static boolean runStage() {
        boolean isCorrect = bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame);
        if (!isCorrect) {
            return manageIncorrectStep();
        }
        return manageCorrectStep();
    }

    private static boolean manageIncorrectStep() {
        if (inputView.readGameCommand().equals("R")) {
            bridgeGame.retry();
            return true;
        }
        outputView.printResult(bridgeGame);
        return false;
    }

    private static boolean manageCorrectStep() {
        if (bridgeGame.hasSucceeded()) {
            outputView.printResult(bridgeGame);
            return false;
        }
        return true;
    }
}

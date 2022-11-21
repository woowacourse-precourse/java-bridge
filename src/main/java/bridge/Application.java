package bridge;

import bridge.constant.PrintMessage;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static boolean isCorrect;
    static BridgeGame bridgeGame;

    public static void main(String[] args) {
        System.out.println(PrintMessage.START_MESSAGE.getString());
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        startGame();
        outputView.printResult(isCorrect, bridgeGame.getMap(isCorrect), bridgeGame.getTrials());
    }

    public static void startGame() {
        while (bridgeGame.isPlaying()) {
            isCorrect = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getMap(isCorrect));
            if (!isCorrect) {
                wrongAnswerHandling();
                return;
            }
        }
    }

    public static void wrongAnswerHandling() {
        boolean isRetrying = bridgeGame.retry(inputView.readGameCommand());
        if (isRetrying) {
            startGame();
        }
    }
}

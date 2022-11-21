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
        boolean isWillingToPlay = true;
        while (bridgeGame.isPlaying() && isWillingToPlay) {
            isCorrect = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getMap(isCorrect));
            if (!isCorrect) {
                isWillingToPlay = wrongAnswerHandling();
            }
        }
    }

    public static boolean wrongAnswerHandling() {
        if (bridgeGame.retry(inputView.readGameCommand())) {
            return true;
        }
        return false;
    }
}

package bridge;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static boolean IsSuccess;
    static BridgeGame bridgeGame;

    public static void main(String[] args) {
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        startGame();
    }

    public static void startGame() {
        bridgeGame.start();
        while (bridgeGame.isPlaying()) {
            IsSuccess = bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getMap());
            if (IsSuccess == false) {
                wrongAnswerHandling();
                return;
            }
        }
        outputView.printResult(true, bridgeGame.getTrials(), bridgeGame.getMap());
    }

    public static void wrongAnswerHandling() {
        if (inputView.readGameCommand() == "R") {
            startGame();
            return;
        }
        outputView.printResult(false, bridgeGame.getTrials(), bridgeGame.getMap());
    }
}

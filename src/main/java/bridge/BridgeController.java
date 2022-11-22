package bridge;

import java.util.List;

public class BridgeController {

    private BridgeGame bridgeGame;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private List<String> bridge;
    private int bridgeSize;
    private boolean success = true;
    private boolean retryOption;

    public void run() {
        outputView.printGameStart();
        gameStart();
    }

    public void gameStart() {
        bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        for (int i = 0; i < bridgeSize; i++) {
            String direction = inputView.readMoving();
            retryOption = bridgeGame.move(direction);
            outputView.printMap(bridgeGame);
            retryOrQuit(i);
            if (!success) break;
        }
        outputView.printResult(bridgeGame, success);
    }

    public void retryOrQuit(int index) {
        if (!retryOption) {
            success = inputView.readGameCommand();
            index = -1;
            bridgeGame.retry();
        }
    }
}
package bridge;

import java.util.List;

public class BridgeController {

    private BridgeGame bridgeGame;
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private int bridgeSize;
    private boolean success = true;
    private boolean retryOption;
    private int index = 0;

    public void run() {
        outputView.printGameStart();
        gameStart();
    }

    public void gameStart() {
        bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
        for ( index = 0; index < bridgeSize; index++) {
            MoveAndPrint();
            boolean x = retryOrQuit();
            if (!x) break;
        }
        outputView.printResult(bridgeGame, success);
    }

    public boolean retryOrQuit() {
        if (!retryOption) {
            success = inputView.readGameCommand();
            if (!success) return false;
            indexReset();
            bridgeGame.retry();
        }
        return true;
    }

    public void indexReset() {
         this.index = -1;
    }
    public void MoveAndPrint() {
        String direction = inputView.readMoving();
        retryOption = bridgeGame.move(direction);
        outputView.printMap(bridgeGame);
    }
}
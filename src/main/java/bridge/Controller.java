package bridge;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    public static final int GAME_FAIL = -1;
    public static final int GAME_SUCCESS = 0;
    public static final int GAME_FINISH = 1;
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private int status;

    public Controller() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    private void startGame() {
        outputView.printStart();
        setGame();
    }

    private void setGame() {
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
    }

    public void run() {
        startGame();
        do {
            tryBridge();
            if (status == GAME_FINISH) {
                break;
            }
        } while (bridgeGame.retry(inputView.readGameCommand()));
        outputView.printResult(status, bridgeGame.getTryCount());
    }

    private void tryBridge() {
        int bridgeIndex = 0;
        do {
            String pos = inputView.readMoving();
            status = bridgeGame.move(pos, bridgeIndex);
            outputView.printMap(pos, bridgeIndex, status);
            bridgeIndex++;
        } while (status == GAME_SUCCESS);
    }
}

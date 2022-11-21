package bridge.domain;

import bridge.BridgeException;
import bridge.GameKeySet;
import bridge.view.InputView;
import bridge.view.InputViewAdapter;
import bridge.view.OutputView;

public class GamePlayer {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;
    private int retryCount;

    public GamePlayer() {
        this.inputView = new InputViewAdapter();
        this.outputView = new OutputView();
        retryCount = 1;
    }

    public void init() {
        int bridgeSize = inputView.readBridgeSize();
        init(bridgeSize);
    }

    public void init(int bridgeSize) {
        this.bridgeGame = new BridgeGame(bridgeSize);
    }

    public void run() {
        isInitialized();
        do {
            move();

            if (bridgeGame.isEnd()) {
                break;
            }

        } while (isGameSustainable());

        outputView.printResult(bridgeGame.getLog(), bridgeGame.isEnd(), retryCount);
    }

    private void move() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getLog());
    }

    private boolean isGameSustainable() {
        String gameCommand = inputView.readGameCommand();

        if (gameCommand.equals(GameKeySet.QUIT.getKeySet())) {
            return false;
        }

        isRetry(gameCommand);
        return true;
    }

    private void isRetry(String gameCommand) {
        if (gameCommand.equals(GameKeySet.RESTART.getKeySet())) {
            retry();
        }
    }

    private void retry() {
        bridgeGame.retry();
        retryCount++;
    }

    private void isInitialized() {
        if (bridgeGame == null) {
            throw new IllegalArgumentException(BridgeException.TOKEN.getMessage() + " 게임 실행 전 게임 초기화가 필요합니다. -> init()");
        }
    }
}

package bridge.controller;

import bridge.BridgeGame;
import bridge.model.BridgeGameResult;
import bridge.model.BridgeSize;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private BridgeSize bridgeSize;
    private Player player;
    private String retryString = "";
    private String moveString = "";
    private final static String ERROR_INVALID_BRIDGE_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final static String ERROR_INVALID_MOVE_COMMAND = "[ERROR] 이동할 칸 입력은 U 혹은 D만 가능합니다.";
    private final static String ERROR_INVALID_RETRY_COMMAND = "[ERROR] 재시도 입력은 R 혹은 Q만 가능합니다.";


    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        player = new Player();
        bridgeGame = new BridgeGame();
    }

    private BridgeSize makeBridge() {
        outputView.printStart();
        bridgeSize = null;
        do {
            outputView.printReadBridgeSize();
            validBridgeSize();
        } while (bridgeSize == null);
        return bridgeSize;
    }

    private void validBridgeSize() {
        try {
            bridgeSize = new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printError(ERROR_INVALID_BRIDGE_SIZE);
        }
    }

    public void readMove() {
        outputView.printReadMoving();
        try {
            moveString = inputView.readMoving();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public boolean move() {
        try {
            readMove();
        } catch (IllegalArgumentException e) {
            outputView.printError(ERROR_INVALID_MOVE_COMMAND);
            return false;
        }
        return true;
    }

    public boolean validateRetryValue() {
        if (retryString.equals(InputView.RETRY_YES) || retryString.equals(InputView.RETRY_NO)) {
            return true;
        }
        return false;
    }

    public boolean readRetry() {
        do {
            outputView.printReadRetry();
            try {
                retryString = inputView.readRetry();
            } catch (IllegalArgumentException e) {
                outputView.printError(ERROR_INVALID_RETRY_COMMAND);
            }
        } while (!validateRetryValue());
        return bridgeGame.retry(retryString);
    }

    public boolean isCleared() {
        if (bridgeGame.getGameStatus() == BridgeGame.GAME_STATUS_CLEAR)
            return true;
        if (readRetry()) {
            return false;
        }
        return true;
    }

    public void printResult(BridgeGameResult bridgeGameResult) {
        outputView.printResult(bridgeGameResult);
    }

    public boolean isEnd() {

        return bridgeGame.getGameStatus() != BridgeGame.GAME_STATUS_NORMAL;
    }

    public void playOneGame() {
        bridgeGame.reGame();
        do {
            if (!move()) {
                continue;
            }
            bridgeGame.move(moveString);
            outputView.printMap(bridgeGame);
        } while (!isEnd());
    }

    public void playGame() {
        bridgeGame = new BridgeGame(makeBridge(), player);
        do {
            playOneGame();
        } while (!isCleared());
        printResult(new BridgeGameResult(bridgeGame.getCleared(), bridgeGame.getTried()));
    }
}

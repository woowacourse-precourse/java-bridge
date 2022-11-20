package bridge.controller;

import bridge.BridgeGame;
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
    private String retryString;
    private String moveString;

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
            outputView.printError("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public String readMove() {
        outputView.printReadMoving();
        try {
            moveString = inputView.readMoving();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return moveString;
    }

    public boolean move() {
        try {
            moveString = readMove();
        } catch (IllegalArgumentException e) {
            outputView.printError("[ERROR] 이동할 칸 입력은 U 혹은 D만 가능합니다.");
            return false;
        }
        return true;
    }

    public boolean readRetry() {
        outputView.printReadRetry();
        do {
            try {
                retryString = inputView.readRetry();
            } catch (IllegalArgumentException e) {
                outputView.printError("[ERROR] 재시도 입력은 R 혹은 Q만 가능합니다.");
            }
        } while (retryString == null);
        return bridgeGame.retry(retryString);
    }


    public void playGame() {
        bridgeGame = new BridgeGame(makeBridge(), player);
        while (!move()) {

        }
        readRetry();
    }
}

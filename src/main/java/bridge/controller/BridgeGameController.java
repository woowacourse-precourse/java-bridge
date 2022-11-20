package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.service.BridgeMakerService;
import bridge.type.GameStatusType;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final BridgeGame bridgeGame;
    private int gameCount;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.bridgeGame = new BridgeGame(createBridge().getBridge());
        this.gameCount = 1;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        while (bridgeGame.getGameStatus().isPlaying()) {
            move();
            if (checkFail()) {
                restartOrEnd();
            }
        }
        printGameResult();
    }

    private void move() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.printPlayingMap());
    }

    private boolean checkFail() {
        return bridgeGame.getGameStatus() == GameStatusType.FAIL;
    }

    private boolean checkEnd() {
        return bridgeGame.getGameStatus() == GameStatusType.END;
    }

    private void restartOrEnd() {
        String status = inputView.readGameCommand();
        if (status.equals("R")) {
            restart();
        }
        if (status.equals("Q")) {
            end();
        }
    }

    private void restart() {
        gameCount++;
        bridgeGame.retry();
    }

    private void end() {
        bridgeGame.end();
    }

    private void printGameResult() {
        if (checkEnd()) {
            outputView.printResult(bridgeGame.printPlayingMap(), bridgeGame.getGameStatus(), gameCount);
        }
    }

    private Bridge createBridge() {
        while (true) {
            try {
                InputView inputView = new InputView();
                int size = inputView.readBridgeSize();
                return BridgeMakerService.createBridge(size);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

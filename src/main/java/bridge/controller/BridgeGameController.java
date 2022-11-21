package bridge.controller;

import static bridge.constant.BridgeConstant.QUIT;
import static bridge.constant.BridgeConstant.RETRY;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMovingResult;
import bridge.service.BridgeMakerService;
import bridge.type.GameStatusType;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final BridgeGame bridgeGame;
    private int gameCount;
    private final BridgeMovingResult bridgeMovingResult;

    public BridgeGameController() {
        List<String> bridgeInfo = createBridge().getBridge();
        bridgeGame = new BridgeGame(bridgeInfo);
        gameCount = 1;
        bridgeMovingResult = new BridgeMovingResult(bridgeInfo);
    }

    public void start() {
        while (bridgeGame.getGameStatus().isPlaying()) {
            move();
            checkFailed();
            checkEnd();
        }
        printGameResult();
    }

    private void move() {
        bridgeGame.move(new InputView().readMoving());
        bridgeMovingResult.updatePlayingMap(bridgeGame.getMovingRecord(), bridgeGame.getStageCount());
        printPlayingMap();
        bridgeGame.increaseStageCount();
    }

    private void restart() {
        gameCount++;
        bridgeGame.retry();
        bridgeMovingResult.initialize();
    }

    private void quit() {
        bridgeGame.quit();
    }

    private void checkEnd() {
        if (bridgeGame.isEnd()) {
            bridgeGame.end();
        }
    }

    private void checkFailed() {
        if(bridgeGame.getGameStatus() == GameStatusType.FAIL) {
            requestRestartOrQuit();
        }
    }

    private void requestRestartOrQuit() {
        String status = new InputView().readGameCommand();
        if (status.equals(RETRY)) {
            restart();
        }
        if (status.equals(QUIT)) {
            quit();
        }
    }

    private void printPlayingMap() {
        new OutputView().printMap(bridgeMovingResult.getPlayingMap());
    }

    private void printGameResult() {
        new OutputView().printResult(bridgeMovingResult.getPlayingMap(), bridgeGame.getGameStatus(), gameCount);
    }

    private Bridge createBridge() {
        while (true) {
            try {
                return BridgeMakerService.createBridge(new InputView().readBridgeSize());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

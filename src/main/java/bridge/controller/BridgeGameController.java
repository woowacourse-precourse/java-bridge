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
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMovingResult bridgeMovingResult;

    public BridgeGameController() {
        List<String> bridgeInfo = createBridge().getBridge();
        bridgeGame = new BridgeGame(bridgeInfo);
        gameCount = 1;
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMovingResult = new BridgeMovingResult(bridgeInfo);
    }

    public void start() {
        while (bridgeGame.getGameStatus().isPlaying()) {
            move();
            checkEnd();
            if (isFailed()) {
                requestRestartOrQuit();
            }
        }
        printGameResult();
    }

    private void move() {
        bridgeGame.move(inputView.readMoving());
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

    private void requestRestartOrQuit() {
        String status = inputView.readGameCommand();
        if (status.equals(RETRY)) {
            restart();
        }
        if (status.equals(QUIT)) {
            quit();
        }
    }

    private void checkEnd() {
        if (bridgeGame.isEnd()) {
            bridgeGame.end();
        }
    }

    private boolean isFailed() {
        return bridgeGame.getGameStatus() == GameStatusType.FAIL;
    }

    private void printPlayingMap() {
        outputView.printMap(bridgeMovingResult.getPlayingMap());
    }

    private void printGameResult() {
        outputView.printResult(bridgeMovingResult.getPlayingMap(), bridgeGame.getGameStatus(), gameCount);
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

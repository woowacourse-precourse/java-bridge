package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.GameStatus;
import bridge.util.BridgeMaker;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;
    int gameCount;
    boolean play;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        Bridge gameBridge = makeGameBridge();
        this.bridgeGame = new BridgeGame(gameBridge);
        this.gameCount = 1;
        this.play = true;
    }

    public void start() {
        while (play) {
            playerMove();
            showBridge(bridgeGame.getGameMap());
            if (!bridgeGame.getStatus().isLife()) {
                askRetry();
            }
        }
        showResult(bridgeGame.getGameMap(), bridgeGame.getStatus(), this.gameCount);
    }

    private void playerMove() {
        bridgeGame.move();
        play = !bridgeGame.isEnd();
    }

    private Bridge makeGameBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = inputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void showBridge(List<List<String>> gameMap) {
        outputView.printNowBridge(gameMap);
    }

    private void askRetry() {
        String status = inputView.readGameCommand();
        if ("R".equals(status)) {
            bridgeGame.retry();
            this.gameCount++;
            return;
        }
        this.play = false;
    }

    private void showResult(List<List<String>> gameMap, GameStatus status, int gameCount) {
        outputView.printResult(gameMap, status, gameCount);
    }
}

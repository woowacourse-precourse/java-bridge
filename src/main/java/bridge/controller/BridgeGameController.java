package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.BridgeNumberGenerator;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {
    BridgeGame bridgeGame;
    int gameCount;
    boolean play;

    public BridgeGameController() {
        Bridge gameBridge = makeGameBridge();
        System.out.println(gameBridge.getBridge());
        this.bridgeGame = new BridgeGame(gameBridge);
        this.gameCount = 1;
        this.play = true;
    }

    public void start() {
        while (play) {
            bridgeGame.move();
            play = !bridgeGame.isEnd();
            showBridge(bridgeGame.getGameMap());
            if (!bridgeGame.isLife()) {
                askRetry();
            }
        }
        showResult(bridgeGame.getGameMap(), bridgeGame.isLife(), this.gameCount);
    }

    private Bridge makeGameBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = InputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private void showBridge(List<List<String>> gameMap) {
        OutputView.printNowBridge(gameMap);
    }

    private void askRetry() {
        String status = InputView.readGameCommand();
        if ("R".equals(status)) {
            bridgeGame.retry();
            this.gameCount++;
            return;
        }
        this.play = false;
    }

    private void showResult(List<List<String>> gameMap, boolean life, int gameCount) {
        OutputView.printResult(gameMap, life, gameCount);
    }
}

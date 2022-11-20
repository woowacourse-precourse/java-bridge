package bridge.controller;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.view.InputView;

public class BridgeGameController {
    BridgeGame bridgeGame;
    boolean play;

    public BridgeGameController() {
        Bridge gameBridge = makeGameBridge();
        this.bridgeGame = new BridgeGame(gameBridge);
        this.play = true;
    }

    public void start() {
        while (play) {
            bridgeGame.move();
            play = !bridgeGame.isEnd();
            if (!bridgeGame.isLife()) {
                askRetry();
            }
        }
    }

    private Bridge makeGameBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = InputView.readBridgeSize();
        return BridgeMaker.makeBridge(bridgeSize);
    }

    private void askRetry() {
        String status = InputView.readGameCommand();
        if ("R".equals(status)) {
            bridgeGame.retry();
            return;
        }
        this.play = false;
    }
}

package bridge.domain;

import bridge.enums.Key;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameManager {

    private final BridgeGame bridgeGame;

    public GameManager(BridgeMaker bridgeMaker) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        boolean status;
        do {
            status = moveForward();
        } while (status && retryOrNot());

        OutputView.printResult(bridgeGame);
    }

    private boolean moveForward() {
        while (bridgeGame.canGoForward()) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
        }
        return bridgeGame.isFail(); // 다리의 끝까지 도달하지 못했는가?
    }

    private boolean retryOrNot() {
        if (Key.matchQuit(InputView.readGameCommand())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }
}

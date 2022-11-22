package bridge.domain;

import bridge.enums.Key;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

// input과 output을 엮어주고, 게임을 진행하는 핵심 로직들을 호출
public class GameManager {

    private final BridgeGame bridgeGame;

    public GameManager(BridgeMaker bridgeMaker) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        while (moveForward() && retryOrNot()) ;

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

package bridge.domain;

import bridge.enums.InputKey;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameManager {
    private final List<String> bridge;
    private final BridgeGame bridgeGame;
    private int position = 0;

    public GameManager(BridgeMaker bridgeMaker) {
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }

    protected GameManager(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        boolean status;
        status = moveForward();
        if (status && retryOrNot()) {
            play();
        }
        OutputView.printResult(bridgeGame);
    }

    private boolean moveForward() {
        while (position < bridge.size() - 1 && position != -1) {
            position = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
        }
        return position != bridge.size() - 1; // 다리의 끝까지 도달하지 못했는가?
    }

    private boolean retryOrNot() {
        if (InputKey.isQuit(InputView.readGameCommand())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }
}

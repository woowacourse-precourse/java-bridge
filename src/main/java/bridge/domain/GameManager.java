package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.enums.InputKey;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameManager {
    private final BridgeMaker bridgeMaker;
    private final List<String> bridge;
    private final BridgeGame bridgeGame;

    public GameManager() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        while (true) {
            int positiion = 0;
            positiion = move(bridgeGame, positiion);
            if (positiion == -1 && retryOrNot(bridgeGame)) {
                continue;
            }
            OutputView.printResult(bridgeGame);
            break;
        }
    }

    private boolean retryOrNot(BridgeGame bridgeGame) {
        String command = InputView.readGameCommand();
        if (InputKey.isQuit(command)) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    private int move(BridgeGame bridgeGame, int positiion) {
        while (positiion < bridgeGame.getBridgeSize() - 1 && positiion != -1) {
            positiion = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
        }
        return positiion;
    }
}

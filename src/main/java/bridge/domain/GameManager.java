package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.enums.GameStatus;
import bridge.enums.InputKey;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameManager {
    private final List<String> bridge;
    private final BridgeGame bridgeGame;
    private int position = 0;

    public GameManager() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridge);
    }

    public void play() {
        GameStatus status;
        do {
            status = moveForward();
        } while (isValid(status));

        OutputView.printResult(bridgeGame);
    }

    private boolean isValid(GameStatus status) {
        return status != GameStatus.LOSE && status != GameStatus.WIN && retryOrNot();
    }

    private GameStatus moveForward() {
        while (position < bridge.size() - 1 && position != -1) {
            position = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
        }
        if (position == bridge.size() - 1) return GameStatus.WIN; // 게임 종료
        return GameStatus.LOSE; // retry?
    }

    private boolean retryOrNot() {
        if (InputKey.isQuit(InputView.readGameCommand())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }
}

package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임을 전체적으로 진행하는 역할을 한다.
 */
public class BridgeGameManager {

    private static List<String> bridge;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private static int gamePlayCount = 1;
    private boolean isClear;

    public BridgeGameManager() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void crossBridge() {
        List<String> playerInput = new ArrayList<>();
        for (int count = 0; count < bridge.size(); count++) {
            String currPlayerInput = InputView.readMoving();
            playerInput.add(currPlayerInput);
            OutputView.printMap(bridge, playerInput);
            isClear = bridgeGame.move(bridge, currPlayerInput);
            if (!isClear) {
                restartGame();
                return;
            }
        }
        endGame();
    }

    public void makeBridge() {
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

    public void endGame() {
        OutputView.printResult(gamePlayCount, isClear);
    }

    public void restartGame() {
        if (bridgeGame.retry(InputView.readGameCommand())) {
            gamePlayCount++;
            crossBridge();
        }
        endGame();
    }

}

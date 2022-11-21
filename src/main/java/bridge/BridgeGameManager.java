package bridge;

import java.util.List;

/**
 * 게임을 전체적으로 진행하는 역할을 한다.
 */
public class BridgeGameManager {

    private static List<String> bridge;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private static int gamePlayCount = 1;

    public BridgeGameManager() {
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void crossBridge() {
        for (int count = 0; count < bridge.size(); count++) {
            if (!bridgeGame.move(bridge, InputView.readMoving())) {
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
        OutputView outputView = new OutputView();
        outputView.printResult();
    }

    public void restartGame() {
        if (bridgeGame.retry(InputView.readGameCommand())) {
            gamePlayCount++;
            crossBridge();
        }
        endGame();
    }

}

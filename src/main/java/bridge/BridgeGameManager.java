package bridge;

import bridge.constant.Status;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임을 전체적으로 진행하는 역할을 한다.
 */
public class BridgeGameManager {

    private final BridgeConnector bridgeConnector;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;
    private static int gamePlayCount = 1;
    private static List<String> bridge;
    private boolean isClear;


    public BridgeGameManager() {
        this.bridgeConnector = new BridgeConnector();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void crossBridge() {
        if (crossSuccess()) {
            isClear = true;
            endGame();
            return;
        }
        isClear = false;
        restartGame();
    }

    public void makeBridge() {
        bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }

    public void endGame() {
        OutputView.printResult(gamePlayCount, isClear, bridgeConnector.toString());
    }

    public void restartGame() {
        if (bridgeGame.retry(InputView.readGameCommand())) {
            gamePlayCount++;
            crossBridge();
        }
        endGame();
    }

    public boolean crossSuccess() {
        List<Status> statuses = new ArrayList<>();
        for (String currSection : bridge) {
            if (currSectionWrong(statuses, currSection)) {
                return false;
            }
        }
        return true;
    }

    public boolean currSectionWrong(List<Status> statuses, String currSection) {
        String playerInput = InputView.readMoving();
        boolean canGo = bridgeGame.move(currSection, playerInput);
        statuses.add(Status.getStatus(playerInput, canGo));
        bridgeConnector.connect(statuses);
        OutputView.printMap(bridgeConnector.toString());
        return canGo;
    }

}

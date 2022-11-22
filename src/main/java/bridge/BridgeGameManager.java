package bridge;

import bridge.constant.Message;
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
    private String result;


    public BridgeGameManager() {
        this.bridgeConnector = new BridgeConnector();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void crossBridge() {
        if (crossSuccess()) {
            result = Message.SUCCESS.getMessage();
            endGame();
            return;
        }
        result = Message.FAIL.getMessage();
        restartGame();
    }

    public void makeBridge() {
        int bridgeSize = InputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void endGame() {
        OutputView.printFinalBridge(bridgeConnector.toString());
        OutputView.printResult(gamePlayCount, result);
    }

    public void restartGame() {
        String playerInput = InputView.readGameCommand();
        if (bridgeGame.retry(playerInput)) {
            gamePlayCount++;
            crossBridge();
            return;
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

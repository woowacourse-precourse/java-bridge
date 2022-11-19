package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {

    private static final String ERROR_EXCEED_BRIDGE_SIZE = "다리 길이보다 초과된 입력을 할 수 없습니다.";
    private final List<String> answerBridge;
    private final List<String> userBridge;
    private int tryCount;
    private GameStatus gameStatus;

    private BridgeStatus(List<String> answerBridge, List<String> userBridge, int tryCount, GameStatus gameStatus) {
        this.answerBridge = answerBridge;
        this.userBridge = userBridge;
        this.tryCount = tryCount;
        this.gameStatus = gameStatus;
    }

    public static BridgeStatus createBridgeStatus(List<String> answerBridge) {
        return new BridgeStatus(answerBridge, new ArrayList<>(), 0, GameStatus.IN_PROGRESS);
    }

    public void addUserMovingCommand(MovingCommand movingCommand) {
        userBridge.add(movingCommand.toString());
        int userBridgeLastIndex = userBridge.size() - 1;
        validateAddUserMovingCommand();
        checkGameStatus(userBridge.get(userBridgeLastIndex), answerBridge.get(userBridgeLastIndex));
    }

    private void checkGameStatus(String requestBridgeElement, String answerBridgeElement) {
        if (!requestBridgeElement.equals(answerBridgeElement)) {
            gameStatus = GameStatus.FAIL;
            return;
        }
        if (answerBridge.size() == userBridge.size()) {
            gameStatus = GameStatus.SUCCESS;
        }
    }

    private void validateAddUserMovingCommand() {
        if (answerBridge.size() < userBridge.size()) {
            throw new IllegalStateException(ERROR_EXCEED_BRIDGE_SIZE);
        }
    }
    public void addTryCount() {
        tryCount++;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}

package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {

    private static final String ERROR_ADD_USER_COMMAND = "게임 상태가 진행 중 상태가 아니면 이동 명령을 추가 할 수 없습니다.";
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
        return new BridgeStatus(answerBridge, new ArrayList<>(), 1, GameStatus.IN_PROGRESS);
    }

    public void addUserMovingCommand(MovingCommand movingCommand) {
        userBridge.add(movingCommand.getName());
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
        if (gameStatus.equals(GameStatus.SUCCESS) || gameStatus.equals(GameStatus.FAIL)) {
            throw new IllegalStateException(ERROR_ADD_USER_COMMAND);
        }
    }

    public void addTryCount() {
        tryCount++;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public boolean needCallRetryGame() {
        return gameStatus.needCallRetry();
    }

    public List<String> getUserBridge() {
        return userBridge;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void clearUserBridge() {
        userBridge.clear();
        gameStatus = GameStatus.IN_PROGRESS;
    }
}

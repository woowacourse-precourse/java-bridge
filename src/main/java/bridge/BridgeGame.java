package bridge;

import bridge.enums.BridgeLine;
import bridge.enums.ErrorMessage;
import bridge.enums.GameState;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final EnumMap<BridgeLine, List<String>> currentBridgeState;
    private int curPosition;
    private GameState gameState;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.currentBridgeState = new EnumMap<>(BridgeLine.class);
        this.curPosition = 0;
        this.gameState = GameState.PLAYING;
        currentBridgeState.put(BridgeLine.UPPER, new ArrayList<>());
        currentBridgeState.put(BridgeLine.LOWER, new ArrayList<>());
    }

    public EnumMap<BridgeLine, List<String>> getCurrentBridgeState() {
        return currentBridgeState;
    }

    public GameState getGameState() {
        return gameState;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public EnumMap<BridgeLine, List<String>> move(String moveChoice) {
        validateMove();
        calMoveResult(moveChoice);
        updateState();

        curPosition++;
        return currentBridgeState;
    }

    private void validateMove() {
        if (!gameState.equals(GameState.PLAYING)) {
            throw new IllegalStateException(ErrorMessage.MOVE_EXCEPTION.getMessage());
        }
    }

    private void calMoveResult(String moveChoice) {
        BridgeLine moveToBridgeLine = BridgeLine.findBy(moveChoice);
        String result = "X";

        Arrays.stream(BridgeLine.values()).forEach(bridgeLine -> currentBridgeState.get(bridgeLine).add(" "));

        if (bridge.get(curPosition).equals(moveChoice)) {
            result = "O";
        }

        currentBridgeState.get(moveToBridgeLine).set(curPosition, result);
    }

    private void updateState() {
        if (getLastStepResult(BridgeLine.UPPER).equals("X") || getLastStepResult(BridgeLine.LOWER).equals("X")) {
            gameState = GameState.FAIL;
            return;
        }
        if (curPosition == bridge.size() - 1) {
            gameState = GameState.SUCCESS;
            return;
        }
        gameState = GameState.PLAYING;
    }

    private String getLastStepResult(BridgeLine bridgeLine) {
        return currentBridgeState.get(bridgeLine).get(curPosition);
    }

    public boolean wasFailedToMove() {
        if (gameState.equals(GameState.FAIL)) {
            return true;
        }
        return false;
    }

    public boolean isCompleted() {
        if (!gameState.equals(GameState.PLAYING)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        currentBridgeState.get(BridgeLine.UPPER).clear();
        currentBridgeState.get(BridgeLine.LOWER).clear();
        curPosition = 0;
        gameState = GameState.PLAYING;
    }
}

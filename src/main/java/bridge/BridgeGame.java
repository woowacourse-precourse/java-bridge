package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<EnumMap<ChoiceOrResult, String>> currentState;
    private int curPosition;
    private GameState gameResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.currentState = new ArrayList<>();
        this.curPosition = 0;
        this.gameResult = GameState.PLAYING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<EnumMap<ChoiceOrResult, String>> move(String moveChoice) {

        validateMove(curPosition);
        calMoveResult(curPosition, moveChoice);
        updateState();

        curPosition++;
        return Collections.unmodifiableList(currentState);
    }

    private void validateMove(int curPosition) {
        if (!gameResult.equals(GameState.PLAYING)) {
            throw new IllegalStateException(ErrorMessage.MOVE_EXCEPTION.getMessage());
        }
    }

    private void calMoveResult(int curPosition, String moveChoice) {
        EnumMap<ChoiceOrResult, String> choiceAndResult = new EnumMap<>(Map.of(ChoiceOrResult.CHOICE, moveChoice));
        if (bridge.get(curPosition).equals(moveChoice)) {
            choiceAndResult.put(ChoiceOrResult.RESULT, "O");
            currentState.add(choiceAndResult);
            return;
        }
        choiceAndResult.put(ChoiceOrResult.RESULT, "X");
        currentState.add(choiceAndResult);
    }

    private void updateState() {
        if (currentState.get(curPosition).get(ChoiceOrResult.RESULT).equals("X")) {
            gameResult = GameState.FAIL;
            return;
        }
        if (curPosition == bridge.size() - 1) {
            gameResult = GameState.SUCCESS;
            return;
        }
        gameResult = GameState.PLAYING;
    }

    public boolean wasFailedToMove() {
        if (gameResult.equals(GameState.FAIL)) {
            return true;
        }
        return false;
    }

    public boolean isCompleted() {
        if (!gameResult.equals(GameState.PLAYING)) {
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
    }
}

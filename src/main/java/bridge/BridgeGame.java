package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BridgeGame {

    private final List<String> bridge;
    private final List<String> moveHistory;
    private int tryCount;
    private BridgeGameState state;

    private BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        tryCount = 1;
        state = BridgeGameState.PLAYING;
        moveHistory = new ArrayList<>();
    }

    public static BridgeGame create(List<String> bridge) {
        List<String> unmodifiableBridge = Collections.unmodifiableList(bridge);
        return new BridgeGame(unmodifiableBridge);
    }

    public int getTryCount() {
        return tryCount;
    }

    public BridgeGameState getState() {
        return state;
    }

    public void move(BridgeGameMovingInput moveInput) {
        recordMove(moveInput);
        checkFailToMove(moveInput);
        checkGameCleared();
    }

    private void recordMove(BridgeGameMovingInput moveInput) {
        moveHistory.add(moveInput.getKey());
    }

    private void checkFailToMove(BridgeGameMovingInput movingInput) {
        if (didFailToMove(movingInput)) {
            state = BridgeGameState.FAIL;
        }
    }

    private boolean didFailToMove(BridgeGameMovingInput moveInput) {
        int location = moveHistory.size() - 1;
        String answer = bridge.get(location);
        return !answer.equals(moveInput.getKey());
    }

    private void checkGameCleared() {
        boolean isGameFailed = state == BridgeGameState.FAIL;
        boolean isLastCell = bridge.size() == moveHistory.size();
        if (!isGameFailed && isLastCell) {
            state = BridgeGameState.CLEAR;
        }
    }

    public void retry() {
        moveHistory.clear();
        tryCount++;
        state = BridgeGameState.PLAYING;
    }

    public String getResult() {
        String upSide = padWithBridge(toBridgeResultLine("U"));
        String downSide = padWithBridge(toBridgeResultLine("D"));
        return upSide + "\n" + downSide;
    }

    private String padWithBridge(String text) {
        return "[ " + text + " ]";
    }

    private String toBridgeResultLine(String selected) {
        return IntStream.range(0, moveHistory.size())
                .mapToObj(i -> toBridgeResultCell(i, selected))
                .collect(Collectors.joining(" | "));
    }

    private String toBridgeResultCell(int index, String selected) {
        String answer = bridge.get(index);
        if (!selected.equals(answer)) {
            return " ";
        }

        boolean isCorrect = answer.equals(moveHistory.get(index));
        if (isCorrect) {
            return "O";
        }
        return "X";
    }

    public boolean isPlaying() {
        return state.equals(BridgeGameState.PLAYING);
    }

    public boolean isCleared() {
        return state.equals(BridgeGameState.CLEAR);
    }
}

package bridge.gameplay;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private final List<String> answerBridge;
    private final List<String> BridgeTrack;
    private int tryCount;

    public BridgeGame(List<String> answerBridge) {
        tryCount = 1;
        this.answerBridge = answerBridge;
        BridgeTrack = new ArrayList<>();
    }

    public void move(String input) {
        BridgeTrack.add(input);
    }

    public void retry() {
        tryCount++;
        reset();
    }
    private void reset() {
        BridgeTrack.clear();
    }

    public List<String> getBridgeTrack() {
        return new ArrayList<>(BridgeTrack);
    }

    public boolean isRecentMoveSuccessful() {
        int lastMoveIndex = BridgeTrack.size() - 1;
        return BridgeTrack.get(lastMoveIndex).equals(answerBridge.get(lastMoveIndex));
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isBridgeGameSuccess() {
        return BridgeTrack.equals(answerBridge);
    }

    public List<String> getAnswerBridge() {
        return new ArrayList<>(answerBridge);
    }
}

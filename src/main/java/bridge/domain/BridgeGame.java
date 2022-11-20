package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private Bridge bridge;
    private List<String> userAnswer;
    private int attempt;

    public BridgeGame() {
        this.userAnswer = new ArrayList<>();
        this.attempt = 1;
    }

    public void initBridge(int size) {
        bridge = new Bridge(size);
    }

    public void initBridge(List<String> bridge) {
        this.bridge = new Bridge(bridge);
    }

    public Progress move(String UorD) {
        userAnswer.add(UorD);
        return compareBridgeAndUser(userAnswer.size() - 1);
    }

    public void retry() {
        attempt++;
        userAnswer = new ArrayList<>();
    }

    private Progress compareBridgeAndUser(int currentIndex) {
        if (bridge.isSameStringWithUser(currentIndex, userAnswer.get(currentIndex))) {
            if (userAnswer.size() == bridge.getBridge().size()) {
                return Progress.SUCCESS;
            }
            return Progress.PROGRESSION;
        }
        return Progress.FAILURE;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public List<String> getUserAnswer() {
        return userAnswer;
    }

    public int getAttempt() {
        return attempt;
    }
}

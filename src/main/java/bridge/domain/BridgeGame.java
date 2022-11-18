package bridge.domain;

import java.util.List;

public class BridgeGame {
    List<String> answerBridge;
    User user;
    public BridgeGame(List<String> answerBridge, User user) {
        this.answerBridge = answerBridge;
        this.user = user;
    }

    public void move() {
    }

    public void retry() {
    }
}

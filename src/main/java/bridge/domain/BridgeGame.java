package bridge.domain;

import java.util.List;

public class BridgeGame {
    private int position;
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.position = 0;
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean comparePositionLength() {
        return this.bridge.size() == this.position;
    }

    public boolean checkThisStep(String userInput) {
        return userInput.equals(getBridge().get(getPosition()));
    }
    public void move() {
        position++;
    }

}

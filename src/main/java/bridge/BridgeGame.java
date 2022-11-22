package bridge.domain;
import java.util.List;

public class BridgeGame {
    private int position;
    private List<String> bridge;
    public BridgeGame(List<String> bridge) {
        this.position = 0;
        this.bridge = bridge;
    }
    public List<String> getBridge() {
        return this.bridge;
    }
    public boolean comparePositionLength() {
        return this.bridge.size() == this.position;
    }
    public boolean correct(String userInput) {
        return userInput.equals(bridge.get(position));
    }
    public void move() {
        position++;
    }
    public void retry() {
        this.position = 0;
    }
}

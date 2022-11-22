package bridge.domain;
import java.util.List;

public class BridgeGame {
    private int position;
    private final List<String> bridge;
    public BridgeGame(List<String> bridge) {
        this.position = 0;
        this.bridge = bridge;
    }
}
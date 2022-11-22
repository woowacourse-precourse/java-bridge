package bridge.domain;
import java.util.List;

public class BridgeGame {
    private int position;
    private final List<String> bridge;
    public BridgeGame(List<String> bridge) {
        this.position = 0;
        this.bridge = bridge;
    }

    public void retry() {
        this.position = 0;
    }

    public int getPosition(){ return this.position;}
}
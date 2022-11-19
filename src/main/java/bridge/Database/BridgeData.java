package bridge.Database;

import java.util.List;

public class BridgeData {

    private List<Integer> bridge;
    private List<Integer> bridgeLayOutByUser;
    private int totalAttempt;

    public void setBridge(List<Integer> bridge) {
        this.bridge = bridge;
    }

    public void setBridgeLayOutByUser(List<Integer> bridgeLayOutByUser) {
        this.bridgeLayOutByUser = bridgeLayOutByUser;
    }
}

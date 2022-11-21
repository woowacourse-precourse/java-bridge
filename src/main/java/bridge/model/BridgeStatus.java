package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeStatus {
    private static List<String> bridgeStatus;

    public void initBridgeStatus() {
        bridgeStatus = new ArrayList<>();
    }
    public void addStatus(String status) {
        bridgeStatus.add(status);
        System.out.println("???");
    }
    public List<String> getStatus() {
        return bridgeStatus;
    }
}

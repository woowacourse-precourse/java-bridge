package bridge;

import java.util.ArrayList;
import java.util.List;

public class CurrentBridgeState {

    private List<String> upBridgeState;
    private List<String> downBridgeState;

    public CurrentBridgeState() {
        upBridgeState = new ArrayList<>();
        downBridgeState = new ArrayList<>();
    }

    public List<String> getUpBridgeState() {
        return upBridgeState;
    }

    public List<String> getDownBridgeState() {
        return downBridgeState;
    }

    public void setUpBridgeState(List<String> upBridgeState) {
        this.upBridgeState = upBridgeState;
    }

    public void setDownBridgeState(List<String> downBridgeState) {
        this.downBridgeState = downBridgeState;
    }
}

package bridge.domain.resources.bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {

    private final List<String> bridgeMap;
    private int inputCount;
    private boolean flag;

    public BridgeMap() {
        this.bridgeMap = new ArrayList<>();
        this.inputCount = 0;
        flag = true;
    }

    public void clearBridgeMap() {
        bridgeMap.clear();
        inputCount = 0;
        flagUp();
    }

    public void add(String upOrDown) {
        bridgeMap.add(upOrDown);
    }

    public void countUp() {
        inputCount++;
    }

    public void flagUp() {
        flag = true;
    }

    public void flagDown() {
        flag = false;
    }

    public List<String> getBridgeMap() {
        return bridgeMap;
    }

    public int getInputCount() {
        return inputCount;
    }

    public boolean getFlag() {
        return flag;
    }

}

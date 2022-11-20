package bridge.structure;


import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean canGo(BridgeMoveValue bridgeMoveValue, int turnCount) {
        String bridgeValue = this.bridge.get(turnCount);
        if (bridgeMoveValue.getStringIdentifier()
                .equals(bridgeValue)) {
            return true;
        }
        return false;
    }
}

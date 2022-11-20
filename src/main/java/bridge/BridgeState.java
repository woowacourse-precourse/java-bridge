package bridge;

public enum BridgeState {
    DOWN(0, "D"),
    UP(1, "U");

    final int stateCode;
    final String stateInfo;

    BridgeState(int stateCode, String stateInfo) {
        this.stateCode = stateCode;
        this.stateInfo = stateInfo;
    }

    public int getStateCode() {
        return stateCode;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}

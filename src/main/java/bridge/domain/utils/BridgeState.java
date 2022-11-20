package bridge.domain.utils;

public enum BridgeState {
    ALIVE_UP("U", true),
    ALIVE_DOWN("D", true),
    DIE_UP("U", false),
    DIE_DOWN("D", false);

    private final String position;
    private final boolean isAlive;

    BridgeState(String position, boolean isAlive) {
        this.position = position;
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getPosition() {
        return position;
    }

    public static BridgeState convertToBridgeState(String position, boolean isAlive) {
        if (position.equals(ALIVE_UP.getPosition()) && isAlive == ALIVE_UP.isAlive())
            return BridgeState.ALIVE_UP;
        if (position.equals(ALIVE_DOWN.getPosition()) && isAlive == ALIVE_DOWN.isAlive())
            return BridgeState.ALIVE_DOWN;
        if (position.equals(DIE_UP.getPosition()) && isAlive == DIE_UP.isAlive())
            return BridgeState.DIE_UP;
        if (position.equals(DIE_DOWN.getPosition()) && isAlive == DIE_DOWN.isAlive())
            return BridgeState.DIE_DOWN;
        return null;
    }
}

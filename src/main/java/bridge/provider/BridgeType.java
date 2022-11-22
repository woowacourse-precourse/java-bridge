package bridge.provider;

public enum BridgeType {
    MOVE_UP("U", 1),
    MOVE_DOWN("D", 0);

    private final String playerInput;
    private final int providerInput;

    BridgeType(String playerInput, int providerInput) {
        this.playerInput = playerInput;
        this.providerInput = providerInput;
    }

    public String getPlayerInput() {
        return playerInput;
    }

    public int getProviderInput() {
        return providerInput;
    }
}

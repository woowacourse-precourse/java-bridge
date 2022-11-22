package bridge;

import java.util.List;

import static bridge.PlayerBridgeChoice.UPPER_BRIDGE;

public class Bridges {

    private static final int UPPER_BRIDGE_INT = 0;
    private static final int LOWER_BRIDGE_INT = 1;
    private static final int MINUS_CRITERIA_VALUE = 1;

    private final List<Bridge> bridgeLines;

    public Bridges(List<Bridge> bridgeLines) {
        this.bridgeLines = bridgeLines;
    }

    public boolean checkPlayerChoiceBridge(PlayerBridgeChoice bridgeChoice, PlayerLocation playerLocation) {
        if (bridgeChoice.getPlayerBridgeChoice().equals(UPPER_BRIDGE)) {
            return this.bridgeLines.get(UPPER_BRIDGE_INT).isMove(playerLocation.getLocation() - MINUS_CRITERIA_VALUE);
        }
        return this.bridgeLines.get(LOWER_BRIDGE_INT).isMove(playerLocation.getLocation() - MINUS_CRITERIA_VALUE);
    }

    public void checkBridgesOX(BridgeRandomNumberGenerator bridgeRandomNumberGenerator) {
        int isOX = bridgeRandomNumberGenerator.generate();
        checkUpperCompartment(isOX);
        checkLowerCompartment(isOX);
    }

    private void checkUpperCompartment(int isOX) {
        if (isOX == LOWER_BRIDGE_INT) {
            this.bridgeLines.get(UPPER_BRIDGE_INT).addMovePossibility();
            this.bridgeLines.get(LOWER_BRIDGE_INT).addMoveImpossibility();
        }
    }

    private void checkLowerCompartment(int isOX) {
        if (isOX == UPPER_BRIDGE_INT) {
            this.bridgeLines.get(LOWER_BRIDGE_INT).addMovePossibility();
            this.bridgeLines.get(UPPER_BRIDGE_INT).addMoveImpossibility();
        }
    }

    public List<Bridge> getBridgeLines() {
        return this.bridgeLines;
    }

}

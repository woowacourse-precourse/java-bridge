package bridge.domain.player;

import bridge.domain.game.BridgeTile;

public class PlayerStep {

    private static final String CORRECT_MOVE = "O";
    private static final String WRONG_MOVE = "X";
    private static final String NOT_MOVE = " ";

    private final BridgeTile playerMoving;
    private final boolean result;

    public PlayerStep(BridgeTile playerMoving, boolean result) {
        this.playerMoving = playerMoving;
        this.result = result;
    }

    public String getMoveResultLog(BridgeTile bridgeTile) {
        if (bridgeTile != playerMoving) {
            return NOT_MOVE;
        }
        if (result) {
            return CORRECT_MOVE;
        }
        return WRONG_MOVE;
    }

    public boolean isMoving() {
        return result;
    }
}

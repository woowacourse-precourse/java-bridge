package bridge.domain.player;

import bridge.domain.game.BridgeTile;

public class PlayerStep {

    private static final String CORRECT_MOVE = "O";
    private static final String WRONG_MOVE = "X";
    private static final String NOT_MOVE = " ";

    private final BridgeTile playerMoving;
    private final boolean movable;

    public PlayerStep(BridgeTile playerMoving, boolean movable) {
        this.playerMoving = playerMoving;
        this.movable = movable;
    }

    public String getMovableLog(BridgeTile bridgeTile) {
        if (bridgeTile != playerMoving) {
            return NOT_MOVE;
        }
        if (movable) {
            return CORRECT_MOVE;
        }
        return WRONG_MOVE;
    }

    public boolean isMovable() {
        return movable;
    }
}

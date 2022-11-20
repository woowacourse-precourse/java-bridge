package bridge.constant;

public enum MoveRule {
    MOVE_UP("U"),
    MOVE_DOWN("D");

    private final String move;

    MoveRule(String move) { this.move = move; }

    public String getMove() {
        return move;
    }
}

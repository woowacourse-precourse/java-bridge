package bridge;


public enum MoveType {
    SPACE("   "),
    O(" O "),
    X(" X ");

    private final String move;

    MoveType(String move) {
        this.move = move;
    }

    public String getValue() {
        return move;
    }
}



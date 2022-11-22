package bridge.view;

public enum Move {
    U("U"), D("D");

    private String move;

    Move(String move) {
        this.move = move;
    }

    public String getMove() {
        return move;
    }
}

package bridge;

public class MoveRecord {
    private final Branch up;
    private final Branch down;

    public MoveRecord() {
        up = new Branch();
        down = new Branch();
    }

    public void moveUP(int index, boolean canMove) {
        up.set(index, Move.findMove(canMove).getNumber());
    }

    public void moveDOWN(int index, boolean canMove) {
        down.set(index, Move.findMove(canMove).getNumber());
    }
}

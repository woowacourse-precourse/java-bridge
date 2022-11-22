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
        down.makeIndex(index);
        down.reset(index);
    }

    public void moveDOWN(int index, boolean canMove) {
        down.set(index, Move.findMove(canMove).getNumber());
        up.makeIndex(index);
        up.reset(index);
    }

    public String getString() {
        return "[ " + up.getString() + " ]\n"
                + "[ " + down.getString() + " ]";
    }
}
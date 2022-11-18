package bridge;

public class CompareBridge {

    private final String move;

    public CompareBridge(String move) {
        this.move = move;
    }

    public CompareBridge getUpSideMove(CompareBridge playerMove, String bridgeElement) {
        if (playerMove.move.equals("U")) {
            return new CompareBridge("   ");
        }
        if (playerMove.move.equals(bridgeElement)) {
            return new CompareBridge(" O ");
        }
        return new CompareBridge(" X ");
    }

    public CompareBridge getDownSideMove(CompareBridge playerMove, String bridgeElement) {
        if (playerMove.move.equals("D")) {
            return new CompareBridge("   ");
        }
        if (playerMove.move.equals(bridgeElement)) {
            return new CompareBridge(" O ");
        }
        return new CompareBridge(" X ");
    }

    @Override
    public String toString() {
        return move.toString();
    }
}

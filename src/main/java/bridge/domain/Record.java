package bridge.domain;


public class Record {

    private BridgeCell move;
    private boolean success;

    public Record(BridgeCell move, boolean success) {
        this.move = move;
        this.success = success;
    }
    
    public boolean sameDirection(BridgeCell direction) {
        return move.equals(direction);
    }

    public boolean isSuccess() {
        return success;
    }
}

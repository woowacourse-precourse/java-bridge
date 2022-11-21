package bridge.domain;


public class Record {

    private BridgeCell move;
    private boolean success;

    public Record(BridgeCell move, boolean success) {
        this.move = move;
        this.success = success;
    }


}

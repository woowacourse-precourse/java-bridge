package bridge;

public enum BridgeDrawing {

    O("O"),
    X("X"),
    BRIDGE_STEP_DRAWING(" %s |"),
    BRIDGE_NO_STEP_DRAWING("   |"),
    BRIDGE_START_DRAWING("["),
    BRIDGE_END_DRAWING("]");


    private String drawing;

    BridgeDrawing(String drawing) {
        this.drawing = drawing;
    }

    @Override
    public String toString() {
        return drawing;
    }
}

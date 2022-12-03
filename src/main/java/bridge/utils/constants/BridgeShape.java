package bridge.utils.constants;

public enum BridgeShape {
    START_BRIDGE("[ "),
    END_BRIDGE(" ]"),
    BOUNDARY_BRIDGE(" | "),
    ANSWER_BRIDGE("O"),
    WRONG_BRIDGE("X"),
    BLANK(" ");

    private final String shape;

    BridgeShape(String shape){
        this.shape = shape;
    }

    public String getShape(){
        return shape;
    }
}

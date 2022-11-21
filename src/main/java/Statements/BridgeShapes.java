package Statements;


import bridge.BridgeGame;

public enum BridgeShapes {
    FIRST_O_BRIDGE("[ O ]"),
    FIRST_EMPTY_BRIDGE("[   ]"),
    FIRST_X_BRIDGE("[ X ]"),
    FIRST_O_BRIDGE_OPENED("[ O |"),
    FIRST_EMPTY_BRIDGE_OPENED("[   |"),
    MIDDLE_O_BRIDGE("| O |"),
    MIDDLE_EMPTY_BRIDGE("|   |"),
    MIDDLE_X_BRIDGE("| X |"),
    LAST_O_BRIDGE("| O ]"),
    LAST_EMPTY_BRIDGE("|   |"),
    LAST_X_BRIDGE("| X |");

    private final String shapes;
    BridgeShapes(String shapes){
        this.shapes = shapes;
    }
    public String build(){
        return shapes;
    }


}

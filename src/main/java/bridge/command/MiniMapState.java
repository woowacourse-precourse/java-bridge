package bridge.command;

public enum MiniMapState {
    START_BRIDGE_FRAME("[ "),
    END_BRIDGE_FRAME(" ]"),
    NOT_EXIST(" "),
    POSSIBLE_MOVE("O"),
    NOT_POSSIBLE_MOVE("X"),
    LINE(" | ");

    private String miniMapState;

    MiniMapState(String miniMapState) {
        this.miniMapState = miniMapState;
    }

    public String getMiniMapState() {
        return miniMapState;
    }
}

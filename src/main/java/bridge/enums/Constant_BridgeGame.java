package bridge.enums;

public enum Constant_BridgeGame {
    UP_SIDE_PROGRESS("upSideProgress"),
    DOWN_SIDE_PROGRESS("downSideProgress"),
    GAME_COMMAND_UP("U"),
    GAME_COMMAND_DOWN("D"),
    GAME_COMMAND_RETRY("R"),
    GAME_COMMAND_QUIT("Q"),
    MOVABLE_CELL("O"),
    UNMOVABLE_CELL("X"),
    BLANK_CELL(" "),
    GAME_RESULT_WIN("성공"),
    GAME_RESULT_LOSE("실패");

    private final String message;

    Constant_BridgeGame(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}

package bridge.utils.constants;

public enum Commons {

    MIN_BRIDGE_RANGE(3),
    MAX_BRIDGE_RANGE(20),
    MOVE_UP("U"),
    MOVE_DOWN("D"),
    GAME_RESTART("R"),
    GAME_QUIT("Q"),
    ;
    private int number;
    private String command;

    Commons(int number) {
        this.number = number;
    }

    Commons(String command) {
        this.command = command;
    }

    public int getNumber() {
        return number;
    }

    public String getCommand() {
        return command;
    }
}

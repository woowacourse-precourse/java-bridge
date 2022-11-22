package bridge.constants;

public enum CommandConstants {
    MOVE_U("U"),
    MOVE_D("D"),
    MOVE_INPUT_O("O"),
    MOVE_INPUT_X("X"),
    MOVE_INPUT_BLANK(" "),
    RETRY_R("R"),
    RETRY_Q("Q");

    private String command;

    CommandConstants(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}

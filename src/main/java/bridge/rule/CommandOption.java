package bridge.rule;

public enum CommandOption {

    RESTART("R"),
    QUIT("Q");

    private final String command;

    CommandOption(String command) {
        this.command = command;
    }

    public static boolean isCorrectCommand(String command) {
        return QUIT.command.equals(command) || RESTART.command.equals(command);
    }

    public static boolean isRetry(String command){
        return command.equals(RESTART.command);
    }
}

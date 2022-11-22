package bridge;

public class CommandParameter {
    private static final String QUIET = "Q";
    private static final String RETRY = "R";

    private final String command;

    public CommandParameter(String command) {
        this.command = command;
    }

    private  void isCommand(String command) {
        if (!command.matches(QUIET) && !command.matches(RETRY)){
            throw new CommandException("[ERROR] Q와 R만 입력할 수 있습니다.");
        }
    }
    public boolean quiet() {
        return command.matches(QUIET);
    }

    public String getCommand() {
        return command;
    }
}

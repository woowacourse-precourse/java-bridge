package bridge;

public class MovingCommandParameter {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private final String movingCommand;

    public MovingCommandParameter(String movingCommand) {
        checkCommand(movingCommand);
        this.movingCommand = movingCommand;
    }

    private static void checkCommand(String movingCommand) {
        if (!movingCommand.matches(UP) && !movingCommand.matches(DOWN)) {
            throw new CommandException("[ERROR] U또는 D를 입력해주세요");
        }
    }

    public String getMovingCommand() {
        return movingCommand;
    }
}

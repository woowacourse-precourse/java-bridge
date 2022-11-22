package bridge;

public enum MovingCommand {

    UP("U", 1),
    DOWN("D", 0);

    private static final String INVALID_USER_INPUT = "이동할 칸은 U 또는 D로 이동할 수 있습니다.";
    private static final String INVALID_NUMBER = "해당하는 명령을 찾을 수 없습니다.";

    private String command;
    private int number;

    MovingCommand(String command, int number) {
        this.command = command;
        this.number = number;
    }

    public static String commandOf(int number) {
        for (MovingCommand cmd : MovingCommand.values()) {
            if (cmd.number == number) return cmd.command;
        }
        throw new IllegalArgumentException(INVALID_NUMBER);
    }
}

package bridge;

public enum MovingCommand {

    UP("U"),
    DOWN("D");

    private static final String errorMessage = "이동할 칸은 U 또는 D로 이동할 수 있습니다.";

    private String command;

    MovingCommand(String command) {
        this.command = command;
    }
}

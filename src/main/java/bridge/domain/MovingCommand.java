package bridge.domain;

public enum MovingCommand {
    UP("U"),
    DOWN("D");

    private static final String ERROR_MOVING_INPUT = "움직임 명령은 U와 D만 입력 가능합니다.";
    private final String name;

    MovingCommand(String name) {
        this.name = name;
    }
}

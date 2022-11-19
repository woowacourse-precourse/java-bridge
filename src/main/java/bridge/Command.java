package bridge;

public enum Command {
    UP("U"),
    DOWN("D"),
    RETRY("R"),
    QUIT("Q");

    private String movement;

    Command(String movement) {
        this.movement = movement;
    }

    public String getValue() {
        return movement;
    }
}

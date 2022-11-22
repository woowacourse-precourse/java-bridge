package bridge.resources;

public enum GameCommand {
    RESTART("R"),
    QUIT("Q"),
    UPPER("U"),
    LOWER("D");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public boolean isEqual(String command) {
        return this.command.equals(command);
    }

    public static void canMove(String move) {
        if (!UPPER.isEqual(move) && !LOWER.isEqual(move)) {
            throw new IllegalArgumentException("[ERROR] U, D 둘중에 하나만 입력하세요");
        }
    }

    public static GameCommand getBridgeCommand(String command) {
        if (UPPER.isEqual(command)) {
            return UPPER;
        }
        return LOWER;
    }

    public static GameCommand reverse(String moveSpace) {
        if (UPPER.isEqual(moveSpace)) {
            return LOWER;
        }
        return UPPER;
    }
}

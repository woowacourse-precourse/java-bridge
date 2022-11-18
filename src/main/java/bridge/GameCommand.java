package bridge;

public enum GameCommand {
    REPLAY,
    QUIT;

    GameCommand() {
    }

    public static GameCommand setCommand(String input) {
        if (input.equals("R")) {
            return GameCommand.REPLAY;
        }
        if (input.equals("Q")) {
            return GameCommand.QUIT;
        }
        throw new IllegalArgumentException("[ERROR] R,Q를 입력해 주세요.");
    }
}

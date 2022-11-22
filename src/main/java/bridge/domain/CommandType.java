package bridge.domain;

public enum CommandType {
    QUIT("Q"),
    RESTART("R");

    private final String value;

    CommandType(String value) {
        this.value = value;
    }

    public static CommandType create(String commandInput) {
        validateCommandType(commandInput);
        if (commandInput.equals("Q")) {
            return CommandType.QUIT;
        }
        return CommandType.RESTART;
    }

    private static void validateCommandType(String input) {
        if (!(input.equals("Q") || input.equals("R"))) {
            throw new IllegalArgumentException("[ERROR] Q 또는 R 를 입력해야 합니다.");
        }
    }

    public  boolean isQuit() {
        return this.value.equals("Q");
    }

}


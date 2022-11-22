package bridge.domain;

import bridge.exception.IllegalArgumentError;

public enum Command {
    Retry("R"),
    Quit("Q");

    private final String type;

    Command(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Command toCommand(String command) {
        for (Command type : Command.values()) {
            if (type.getType().equals(command)) {
                return type;
            }
        }
        throw new IllegalArgumentError("올바르지 않은 명령어입니다.");
    }
}
package bridge.model;

import java.util.Arrays;

public enum ContinueType {
    RETRY("R", "재시도"),
    QUIT("Q", "종료");

    private final String command;

    private final String description;

    ContinueType(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static ContinueType searchContinueTypeByCommand(String command) {
        return Arrays.stream(ContinueType.values())
                .filter(ct -> ct.command.equals(command))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("허용되지 않는 글자입니다. 재시도 여부를 선택할 수 없습니다."));
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}

package types;

import java.util.Arrays;

public enum RetryCommand {
    RETRY("R"), QUIT("Q");

    private String label;

    RetryCommand(String retryCommand) {
        this.label = retryCommand;
    }

    public static RetryCommand of(String retryCommand) {
        return Arrays.stream(values())
                .filter((v) -> retryCommand.equals(v.label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "[ERROR] 해당하는 RetryCommand가 존재하지 않습니다. 재시작 명령어는 재시작(R) / 종료(Q) 뿐입니다."));
    }

}

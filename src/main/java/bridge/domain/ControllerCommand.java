package bridge.domain;

import bridge.command.RetryCommand;

import java.util.Arrays;
import java.util.Objects;

/**
 * 재시도, 종료에 해당하는 P,Q를 담당하는 클래스
 */
enum ControllerCommand {
    RETRY("R"),
    QUIT("Q");

    private final String key;

    ControllerCommand(final String key) {
        this.key = key;
    }

    public static ControllerCommand from(final RetryCommand retryCommand) {
        return Arrays.stream(ControllerCommand.values())
                .filter(it -> Objects.equals(it.key, retryCommand.getRetry()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("R,Q 만 입력 가능합니다"));
    }

    @Override
    public String toString() {
        return "ControllerCommand : " + key;
    }
}

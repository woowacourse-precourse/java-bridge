package bridge.domain;

import bridge.util.ErrorMessage;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private String code;
    private static final Map<String, GameCommand> BY_CODE =
            Stream.of(values()).collect(Collectors.toMap(GameCommand::getCode, e -> e));

    GameCommand(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static GameCommand findByCommand(String code) {
        if(!BY_CODE.containsKey(code)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_COMMAND_VALUE);
        }
        return BY_CODE.get(code);
    }
}

package bridge.enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GameStatus {
    ONGOING("진행중"),
    SUCCESS("성공"),
    FAIL("실패")
    ;

    private final String label;

    GameStatus(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }

    private static final Map<String, GameStatus> BY_LABEL =
            Stream.of(values()).collect(Collectors.toMap(GameStatus::label, Function.identity()));

    public static GameStatus valueOfLabel(String label) {
        return BY_LABEL.get(label);
    }

}

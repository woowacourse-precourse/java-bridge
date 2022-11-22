package bridge.model;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum PlayerStatus {
    COMPLETE_CROSSING_BRIDGE(true,"성공"),
    FALL_BRIDGE(false, "실패");

    private final static Map<Boolean, PlayerStatus> BY_BOOLEAN = Stream.of(values())
            .collect(Collectors.toMap(PlayerStatus::isSurvive, Function.identity()));

    private final boolean isSurvive;
    private final String content;

    PlayerStatus(boolean isSurvive, String content) {
        this.isSurvive = isSurvive;
        this.content = content;
    }

    public boolean isSurvive() {
        return isSurvive;
    }

    public String getContent() {
        return content;
    }

    public static PlayerStatus findBySurvive(Boolean isSurvive) {
        return BY_BOOLEAN.get(isSurvive);
    }
}

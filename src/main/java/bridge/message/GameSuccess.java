package bridge.message;

import java.util.Arrays;
import java.util.function.Predicate;

public enum GameSuccess {
    SUCCESS("게임 성공 여부: 성공", x -> x),
    NOT_SUCCESS("게임 성공 여부: 실패", x -> !x);

    private final String message;
    private final Predicate<Boolean> predicate;

    GameSuccess(String message, Predicate<Boolean> predicate) {
        this.message = message;
        this.predicate = predicate;
    }

    public String getMessage() {
        return message;
    }

    public boolean test(boolean result) {
        return predicate.test(result);
    }

    public static GameSuccess findMessage(boolean result) {
        return Arrays.stream(GameSuccess.values())
                .filter(x -> x.test(result))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}

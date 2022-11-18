package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum GameStateType {

    INIT(0), PLAY(1), FAIL(2), RESULT(3), DONE(4);

    private static final String NULL_ERROR = "존재하지 않는 GameState를 호출했습니다.";
    private final int order;

    GameStateType(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    private static final Map<Integer, GameStateType> states =
            Arrays.stream(GameStateType.values())
                    .collect(Collectors.toUnmodifiableMap(GameStateType::getOrder, Function.identity()));

    public GameStateType getNextState() {
        GameStateType selectedState = states.get(order + 1);
        if (selectedState == null) {
            throw new IllegalStateException(NULL_ERROR);
        }
        return selectedState;
    }
}

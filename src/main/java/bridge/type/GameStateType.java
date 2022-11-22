package bridge.type;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum GameStateType {

    STATE_INIT(0),
    STATE_PLAY(1),
    STATE_FAIL(2),
    STATE_RESULT(3),
    STATE_DONE(4);

    private static final String NULL_ERROR = "존재하지 않는 STATE 순서 번호입니다.";
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

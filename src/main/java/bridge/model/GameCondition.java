package bridge.model;

import java.util.Arrays;

public enum GameCondition {

    RESTART("R"),
    QUIT("Q");

    private final String condition;

    GameCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public static GameCondition from(String input) {
        return Arrays.stream(GameCondition.values())
                .filter(condition -> condition.getCondition().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("해당하는 상태가 존재하지 않습니다. 입력 : %s", input)));
    }

}

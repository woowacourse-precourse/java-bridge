package bridge.domain;

import java.util.Objects;

public class Deck {

    public Deck(String direction) {
        validateDirection(direction);
    }

    private void validateDirection(String direction) {
        if (Objects.equals(direction, "U")) {
            return;
        }
        if (Objects.equals(direction, "D")) {
            return;
        }
        throw new IllegalArgumentException("방향은 위, 아래만 가능합니다");
    }
}

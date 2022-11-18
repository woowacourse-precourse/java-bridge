package bridge.domain;

import bridge.constant.Direction;

public class Deck {

    private final Direction direction;

    public Deck(String capitalLetter) {
        this.direction = Direction.from(capitalLetter)
                .orElseThrow(() -> new IllegalArgumentException("방향은 위, 아래만 가능합니다"));
    }
}

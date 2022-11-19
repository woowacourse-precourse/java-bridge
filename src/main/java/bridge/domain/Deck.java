package bridge.domain;

import bridge.constant.Direction;

public class Deck {

    private final Direction movableDirection;

    public Deck(String capitalLetter) {
        this.movableDirection = directionFrom(capitalLetter);
    }

    public boolean isMovable(Direction direction) {
        return movableDirection.equals(direction);
    }

    private Direction directionFrom(String capitalLetter) {
        return Direction.from(capitalLetter)
                .orElseThrow(() -> new IllegalArgumentException("방향은 위, 아래만 가능합니다"));
    }
}

package bridge.domain;

import bridge.constant.Direction;

public class Deck {

    private final Direction movableDirection;

    public Deck(String capitalLetter) {
        this.movableDirection = directionFrom(capitalLetter);
    }

    public boolean isMovable(String capitalLetter) {
        return movableDirection.equals(directionFrom(capitalLetter));
    }

    private Direction directionFrom(String capitalLetter) {
        return Direction.from(capitalLetter)
                .orElseThrow(() -> new IllegalArgumentException("방향은 위, 아래만 가능합니다"));
    }
}

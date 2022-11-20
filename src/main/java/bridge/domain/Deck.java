package bridge.domain;

import bridge.constant.Direction;

public class Deck {

    private final Direction movableDirection;

    public Deck(String capitalLetter) {
        this.movableDirection = Direction.from(capitalLetter);
    }

    public boolean isMovable(Direction direction) {
        return movableDirection.equals(direction);
    }
}

package bridge.domain;

public enum Movement {
    UP("U", 1),
    DOWN("D", 0);

    private String direction;
    private int randomDigit;

    Movement(String direction, int randomDigit) {
        this.direction = direction;
        this.randomDigit = randomDigit;
    }

    public String getDirection() {
        return direction;
    }

    public int getRandomDigit() {
        return randomDigit;
    }

    public static Movement getMovementByDirection(String direction) {
        Movement movement = Movement.findBy(direction);
        return movement;
    }

    private static Movement findBy(String direction) {
        for (Movement movement : Movement.values()) {
            if (movement.direction.equals(direction)) {
                return movement;
            }
        }
        return null;
    }
}

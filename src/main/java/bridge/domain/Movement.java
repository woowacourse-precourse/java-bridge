package bridge.domain;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    String direction;
    int randomDigit;

    Direction(String direction, int randomDigit) {
        this.direction = direction;
        this.randomDigit = randomDigit;
    }

    public String getDirection() {
        return direction;
    }

    public int getRandomDigit() {
        return randomDigit;
    }

}

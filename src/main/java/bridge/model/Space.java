package bridge.model;

public enum Space {
    TOP("U", 1),
    BOTTOM("D", 0);
    private String direction;
    private int number;

    Space(String direction, int number) {
        this.direction = direction;
        this.number = number;
    }

    public String getDirection() {
        return direction;
    }

    public int getNumber() {
        return number;
    }
}

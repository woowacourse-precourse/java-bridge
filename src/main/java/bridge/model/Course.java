package bridge.model;

public enum Course {
    TOP("U", 1),
    BOTTOM("D", 0);
    private String direction;
    private int number;

    Course(String direction, int number) {
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

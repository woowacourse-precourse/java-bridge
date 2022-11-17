package bridge.generator;

public enum UpDown {
    UP(1,"U"),
    DOWN(0,"D");

    private int number;
    private String direction;

    UpDown(int number, String direction) {
        this.number = number;
        this.direction = direction;
    }

    public int getNumber() {
        return number;
    }

    public String getDirection() {
        return direction;
    }
}

package bridge;

public enum MovingEnum {
    U(1), D(0);

    private final int num;

    MovingEnum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}

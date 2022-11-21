package bridge;

public enum UpOrDown {
    UP(2),
    DOWN(1)
    ;
    private final int value;
    UpOrDown(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package bridge;

public enum UpOrDown {
    UP(2),
    DOWN(1)
    ;
    private final Integer value;
    UpOrDown(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}

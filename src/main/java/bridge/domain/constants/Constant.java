package bridge.domain.constants;

public enum Constant {
    MINIMUM_LENGTH_INCLUSIVE(3),
    MAXIMUM_LENGTH_INCLUSIVE(20),
    UPPER_BLOCK_INDEX(0),
    LOWER_BLOCK(1);

    private int value;
    Constant(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

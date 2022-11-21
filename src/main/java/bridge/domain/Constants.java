package bridge.domain;

public enum Constants {
    MINIMUM_LENGTH_INCLUSIVE(3),
    MAXIMUM_LENGTH_INCLUSIVE(20);

    private int value;
    Constants(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package bridge.bridgeMaker.bridge;

public interface Bridge {
    String getDirection();

    int getValue();

    default boolean isSame(int value) {
        return getValue() == value;
    }
}

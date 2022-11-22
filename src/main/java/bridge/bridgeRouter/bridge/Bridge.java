package bridge.bridgeRouter.bridge;

public interface Bridge {
    String getDirection();

    int getValue();

    int getIndex();

    default boolean isSame(int value) {
        return getValue() == value;
    }
}

package bridge.EnumCollections;

public enum BridgeType {
    UP('U', 1),
    DOWN('D', 0);

    private char position;
    private int randomValue;

    BridgeType(char position, int randomValue) {
        this.position = position;
        this.randomValue = randomValue;
    }

    public char getPosition() {
        return position;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public static boolean isPosition(char input) {
        return input == UP.getPosition() || input == DOWN.getPosition();
    }
}

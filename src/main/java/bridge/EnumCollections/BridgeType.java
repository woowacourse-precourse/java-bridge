package bridge.EnumCollections;

public enum BridgeType {
    UP("U", 1),
    DOWN("D", 0);

    private String position;
    private int randomValue;

    BridgeType(String position, int randomValue) {
        this.position = position;
        this.randomValue = randomValue;
    }

    public String getPosition() {
        return position;
    }

    public static String getPosition(int input) {
        if(input == UP.randomValue) {
            return UP.position;
        }
        return DOWN.position;
    }

    public static BridgeType getBridgeType(String input) {
        if(UP.position.equals(input)) {
            return BridgeType.UP;
        }
        return BridgeType.DOWN;
    }

    public int getRandomValue() {
        return randomValue;
    }


    public static boolean isPosition(String input) {
        return input.equals(UP.getPosition()) || input.equals(DOWN.getPosition());
    }
}

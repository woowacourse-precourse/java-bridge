package enumCollections;

public enum Side {
    UP("U", 1, 0),
    DOWN("D", 0, 1);

    private final String bridgeSavingFormat;
    private final int number;
    private final int index;

    Side(String bridgeSavingFormat, int number, int index) {
        this.bridgeSavingFormat = bridgeSavingFormat;
        this.number = number;
        this.index = index;
    }

    public static String getBridgeSavingFormat(int number) {
        if (UP.number == number) {
            return UP.bridgeSavingFormat;
        }
        return DOWN.bridgeSavingFormat;
    }

    public static boolean isBridgeSavingFormat(String input) {
        if (!UP.bridgeSavingFormat.equals(input) && !DOWN.bridgeSavingFormat.equals(input)) {
            return false;
        }
        return true;
    }

    public static int getIndex(Side side) {
        return side.index;
    }

    public static Side getPosition(String status) {
        if (Side.UP.bridgeSavingFormat == status) {
            return Side.UP;
        }
        return Side.DOWN;
    }

    public static Side getOppositePosition(Side side) {
        if (side == Side.UP) {
            return Side.DOWN;
        }
        return Side.UP;
    }
}

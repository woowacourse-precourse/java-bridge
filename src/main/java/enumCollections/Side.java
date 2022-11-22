package enumCollections;

public enum Side {
    UP("U", 1, 0),
    DOWN("D", 0, 1);

    private final String bridgeSavingFormat;
    private final int generationNumber;
    private final int mapIndex;

    Side(String bridgeSavingFormat, int generationNumber, int mapIndex) {
        this.bridgeSavingFormat = bridgeSavingFormat;
        this.generationNumber = generationNumber;
        this.mapIndex = mapIndex;
    }

    public static String getBridgeSavingFormat(int generationNumber) {
        if (UP.generationNumber == generationNumber) {
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

    public static Side get(String bridgeSavingFormat) {
        if (UP.bridgeSavingFormat.equals(bridgeSavingFormat)) {
            return UP;
        }
        return DOWN;
    }

    public int getIndex() {
        return this.mapIndex;
    }

    public Side getOppositePosition() {
        if (this == UP) {
            return DOWN;
        }
        return UP;
    }
}
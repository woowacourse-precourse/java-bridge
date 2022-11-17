package constant;

public enum GameConstant {
    RANDOM_LOWER_INCLUSIVE(0),
    RANDOM_UPPER_INCLUSIVE(1),
    BRIDGE_SIZE_START_INCLUSIVE(3),
    BRIDGE_SIZE_END_INCLUSIVE(20);

    public final int gameConstant;

    GameConstant(final int gameConstant) {
        this.gameConstant = gameConstant;
    }

    public int getConstant() {
        return gameConstant;
    }
}

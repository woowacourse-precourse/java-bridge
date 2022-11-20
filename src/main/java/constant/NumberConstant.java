package constant;

public enum NumberConstant {
    RANDOM_LOWER_INCLUSIVE(0),
    RANDOM_UPPER_INCLUSIVE(1),
    UP_SIDE(1),
    DOWN_SIDE(0),
    BRIDGE_SIZE_START_INCLUSIVE(3),
    BRIDGE_SIZE_END_INCLUSIVE(20),
    FIRST_TRY(1),
    ONE_LETTER(1),
    TWO_LETTERS(2),
    FIRST_INDEX(0);

    public final int numberConstant;

    NumberConstant(final int numberConstant) {
        this.numberConstant = numberConstant;
    }

    public int getConstant() {
        return numberConstant;
    }
}

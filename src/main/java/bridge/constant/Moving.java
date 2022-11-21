package bridge.constant;

public enum Moving {
    U, D;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    public static Moving getNextAnswer(int randomNumber) {
        if (randomNumber == RANDOM_UPPER_INCLUSIVE) {
            return U;
        }
        return D;
    }
}

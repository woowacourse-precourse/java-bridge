package bridge;

public enum Sign {
    RIGHT("O"),
    WRONG("X");
    private final String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}

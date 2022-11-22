package bridge;

public enum Bridge {
    AVAILABLE(" O "),
    UNAVAILABLE(" X "),
    START("["),
    END("]"),
    BLANK("   "),
    DIVISION("|"),
    ;

    private final String value;

    Bridge(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

package bridge;

public enum Regex {
    NUMBER("^[0-9]+$"),
    ONE_CHAR("^[A-Z]$");

    private final String value;

    Regex(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

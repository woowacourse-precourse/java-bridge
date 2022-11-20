package bridge;

public enum StringValue {

    QUIT("Q");

    private final String stringValue;
    StringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getValue() {
        return stringValue;
    }

    public boolean isEqual(String word) {
        return stringValue.equals(word);
    }
}

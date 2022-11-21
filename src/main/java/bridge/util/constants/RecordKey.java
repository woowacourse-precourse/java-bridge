package bridge.util.constants;

public enum RecordKey {
    UPPER_RECORD_KEY("upperCrossedRecord"),
    LOWER_RECORD_KEY("lowerCrossedRecord");

    private String value;

    RecordKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

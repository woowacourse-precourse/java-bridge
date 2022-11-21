package bridge.enums;

public enum SystemOperation {
    QUIT("Q"),
    RETRY("R");

    private String value;

    SystemOperation(String value) {
        this.value = value;
    }

    public static SystemOperation findByValue(String value) {
        for (SystemOperation systemOperation : SystemOperation.values()) {
            if (systemOperation.value.equals(value)) {
                return systemOperation;
            }
        }

        return null;
    }
}

package bridge.domain;

public enum MapSignature {

    SUCCESS("O"),
    FAIL("X"),
    BLANK(" "),
    ;

    private final String signature;

    MapSignature(String signature) {
        this.signature = signature;
    }

    public static String getSignatureFromRecord(Record record, BridgeCell direction) {
        if (!record.sameDirection(direction)) {
            return BLANK.signature;
        }
        if (record.isSuccess()) {
            return SUCCESS.signature;
        }
        return FAIL.signature;
    }
}

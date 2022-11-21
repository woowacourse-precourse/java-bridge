package bridge.domain.code;

public enum SurviveStatus {
    SURVIVE("O", true),
    DIE("X", false);

    private static final String RESULT_STATUS_FORMAT_CODE = " %s ";
    private final String surviveStatusCode;
    private final boolean surviveStatusValue;

    SurviveStatus(final String code, final boolean value) {
        this.surviveStatusCode = code;
        this.surviveStatusValue = value;
    }

    public static SurviveStatus convertValueToStatus(BridgePosition originalPosition, BridgePosition targetPosition) {
        if (originalPosition.equals(targetPosition)) {
            return SURVIVE;
        }
        return DIE;
    }

    public boolean isAlive() {
        return surviveStatusValue;
    }

    public String resultSurviveStatus(boolean statusValue) {
        if (statusValue) {
            return String.format(RESULT_STATUS_FORMAT_CODE, this.surviveStatusCode);
        }
        return String.format(RESULT_STATUS_FORMAT_CODE, " ");
    }
}

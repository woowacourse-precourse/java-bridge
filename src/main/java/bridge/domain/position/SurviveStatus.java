package bridge.domain.position;

public enum SurviveStatus {
    SURVIVE("O", true),
    DIE("X", false);

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
}

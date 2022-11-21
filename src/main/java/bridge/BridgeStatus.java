package bridge;

import java.util.Arrays;

public enum BridgeStatus {
    UPUP("UU","O "),
    UPDOWN("UD","X "),
    DOWNDOWN("DD"," O"),
    DOWNUP("DU"," X");

    private final String status;
    private final String resultOfStatus;

    BridgeStatus(String status,String resultOfStatus) {
        this.status = status;
        this.resultOfStatus = resultOfStatus;
    }

    public static String getStatus(String stauts) {
        return Arrays.stream(BridgeStatus.values())
                .filter(bridgeStatus -> bridgeStatus.status.equals(stauts))
                .map(bridgeStatus -> bridgeStatus.resultOfStatus)
                .findAny()
                .orElse(null);
    }
}

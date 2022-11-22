package bridge.domain;

import java.util.List;

public class BridgeStatusSaver {

    private List<String> bridgeMovingStatus;//이동한 다리의 현재 상태
    private List<String> bridgeUpDown;//다리의 위, 아래칸 정보

    public BridgeStatusSaver(List<String> bridgeMovingStatus, List<String> bridgeUpDown) {
        this.bridgeMovingStatus = bridgeMovingStatus;
        this.bridgeUpDown = bridgeUpDown;
    }


}

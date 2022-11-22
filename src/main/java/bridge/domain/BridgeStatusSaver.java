package bridge.domain;

import java.util.List;
import java.util.Objects;

public class BridgeStatusSaver {

    private List<String> bridgeMovingStatus;//사용자가 입력한 다리 위, 아래 칸의 정보의 결과
    private List<String> bridgeUpDown;//다리의 위, 아래칸 정보

    public BridgeStatusSaver(List<String> bridgeMovingStatus, List<String> bridgeUpDown) {
        this.bridgeMovingStatus = bridgeMovingStatus;
        this.bridgeUpDown = bridgeUpDown;
    }

    public void saveMovingStatus(final String movingStatus) {
        final boolean correctBridge = validateCorrectBridge(movingStatus);

        if (correctBridge) {
            this.bridgeMovingStatus.add(movingStatus);
        }
        if (!correctBridge) {
            this.bridgeMovingStatus.add(BridgeMapper.FAIL.getUpDownInformation() + movingStatus);
        }
    }

    private boolean validateCorrectBridge(final String movingStatus) {
        int firstIndex = 0;
        int lastIndex = bridgeMovingStatus.size();

        if (!movingStatus.isEmpty()) {
            return compareBridge(bridgeUpDown.get(firstIndex), movingStatus);
        }
        return compareBridge(bridgeUpDown.get(lastIndex), movingStatus);
    }

    private boolean compareBridge(final String bridge, final String movingStatus) {
        return bridge.equals(movingStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        BridgeStatusSaver that = (BridgeStatusSaver) o;
        return Objects.equals(bridgeMovingStatus, that.bridgeMovingStatus);
    }
}

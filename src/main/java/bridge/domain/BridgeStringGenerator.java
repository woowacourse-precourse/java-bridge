package bridge.domain;

import bridge.domain.enumeration.BridgeStatus;
import bridge.dto.BridgeDto;
import java.util.List;

public class BridgeStringGenerator {

    final List<String> bridge;
    final int currentStage;
    final boolean isFail;

    public BridgeStringGenerator(BridgeDto bridgeDto, boolean isFail) {
        this.bridge = bridgeDto.getBridge();
        this.currentStage = bridgeDto.getCurrentStage();
        this.isFail = isFail;
    }

    @Override
    public String toString() {
        String str = "";
        for (BridgeStatus bridgeStatus : BridgeStatus.values()) {
            str += "[ ";
            str = mapToString(str, bridgeStatus);
            str += "]\n";
        }
        return str;
    }

    private String mapToString(String str, BridgeStatus bridgeStatus) {
        for (int idx = 0; idx < currentStage; idx++) {
            str = addOorSpace(str, bridgeStatus, idx);
            str = checkLast(str, idx);
        }
        if (isFail) {
            str = addXorSpace(str, bridgeStatus);
        }
        return str;
    }

    private String addXorSpace(String str, BridgeStatus bridgeStatus) {
        if (!bridge.get(currentStage).equals(bridgeStatus.getName())) {
            str += "X ";
            return str;
        }
        str += "  ";
        return str;
    }

    private String checkLast(String str, int idx) {
        if (idx != currentStage - 1 || isFail) {
            str += "| ";
        }
        return str;
    }

    private String addOorSpace(String str, BridgeStatus bridgeStatus, int idx) {
        if (bridge.get(idx).equals(bridgeStatus.getName())) {
            str += "O ";
            return str;
        }
        str += "  ";
        return str;
    }
}

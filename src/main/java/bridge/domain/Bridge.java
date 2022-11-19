package bridge.domain;

import java.util.List;

public class Bridge {
    public List<String> bridgeStatus;

    public Bridge(List<String> bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    public int getBridgeLength() {
        return bridgeStatus.size();
    }

    public String judgeMoving(String moving, int count) {
        if (bridgeStatus.get(count).equals(moving)){
            return "O";
        }
        return "X";

    }
}

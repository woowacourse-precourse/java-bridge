package bridge.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void move(BridgeDTO bridgeDTO) {
        bridgeDTO.setMovePoint(bridgeDTO.getMovePoint() + 1);
    }

    public void retry(BridgeDTO bridgeDTO) {
        bridgeDTO.setMovePoint(0);
        bridgeDTO.clearInitializeLine();
        bridgeDTO.setRetry(bridgeDTO.getRetry() + 1);
    }
}

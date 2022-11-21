package bridge.controller;

import bridge.domain.BridgeDestination;
import bridge.domain.BridgeProcess;
import bridge.domain.BridgePrinting;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeProcess bridgeProcess = new BridgeProcess();
    private BridgeDestination bridgeDestination = new BridgeDestination();
    private int gameCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void start(List<String> bridgeState, int bridgeSize) {
        int moveIndex = move(bridgeState, bridgeSize);
        afterMove(bridgeState, bridgeSize,moveIndex);
    }

    public int move(List<String> bridgeState, int bridgeSize) {
        int idx = bridgeProcess.moveProcess(bridgeState, bridgeSize);
        return idx;
    }


    public void afterMove(List<String> bridgeState, int bridgeSize, int index) {
        if (bridgeDestination.isReachFinal(bridgeSize, index, gameCount)) {
            return;
        }
        if (bridgeDestination.judgeRestartOrOver()) {
            retry(bridgeSize, bridgeState);
            return;
        }
        bridgeDestination.setQuit(bridgeSize, index, gameCount);
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int bridgeSize,
        List<String> bridgeState) { // 수정 부분 체크 retry 는 조금 별로 더 수정해야할 거 같음 retry말고 이전 작업에서처리
        gameCount++;
        BridgePrinting.initRestart();
        start(bridgeState, bridgeSize);
        return;
    }


}

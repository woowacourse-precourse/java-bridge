package bridge.domain.game;

import bridge.domain.Bridge;

import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */

public class BridgeGame {
    private Bridge bridge;
    private Progress progress;
    private int totalTrial;

    public BridgeGame(List<String> answerBridge) {
        progress = new Progress();
        bridge = new Bridge(answerBridge);
        totalTrial = 0;
    }


    public Bridge getBridge() {
        return bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String userStep) {
        SuccessStep whetherSuccess = bridge.go(userStep);
        return progress.saveProgress(whetherSuccess, userStep);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>ß
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        totalTrial++;
        progress = new Progress();
    }

    public boolean dieOrNot(SuccessStep successStep) {
        return successStep.getStatus();
    }
}

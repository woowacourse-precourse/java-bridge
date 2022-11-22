package bridge.service;

import bridge.BridgeMaker;
import bridge.config.AppConfig;
import bridge.domain.Bridge;
import bridge.domain.TryCount;
import bridge.rule.EndRule;

import static bridge.util.Constant.*;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(Bridge bridge) {
        bridge.step();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static TryCount retry(Bridge bridge, TryCount tryCount) {
        bridge.removeUnsafeSpot();
        return tryCount.addCount();
    }

    public static Bridge generateBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(AppConfig.selectNumberGenerator());
        List<String> baseBridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(FIRSTPOSITION, baseBridge);
    }

    public static TryCount getFinalResult(Bridge bridge, TryCount tryCount) {
        while (!bridge.isLastStep()) {
            String moveTo = LocationSelector.selectMoveTo(bridge);
            if (isQuit(bridge, moveTo)) {
                return tryCount;
            }
            tryCount = moveOrRetry(bridge, tryCount, moveTo);
        }
        return tryCount;
    }

    private static TryCount moveOrRetry(Bridge bridge, TryCount tryCount, String moveTo) {
        if (!bridge.isSafe(moveTo)) {
            tryCount = BridgeGame.retry(bridge, tryCount);
        }
        if (bridge.isSafe(moveTo)) {
            BridgeGame.move(bridge);
        }
        return tryCount;
    }

    private static boolean isQuit(Bridge bridge, String moveTo) {
        if (!bridge.isSafe(moveTo)) {
            if (EndRule.selectQuit()) {
                return true;
            }
        }
        return false;
    }
}

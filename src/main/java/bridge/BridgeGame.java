package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private int currentIndex = 0;

    StringBuilder upBridge = new StringBuilder();
    StringBuilder downBridge = new StringBuilder();

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (currentIndex != 0) {
            upBridge.append(BridgeStatus.NEXT.string);
            downBridge.append(BridgeStatus.NEXT.string);
        }

        upBridge.append(getBridgeStatusString("U", moving));
        downBridge.append(getBridgeStatusString("D", moving));

        currentIndex++;
    }

    private String getBridgeStatusString(String upDown, String moving) {
        if (upDown.equals(moving)) {
            return getBridgeSuccessOrFailure(moving);
        }
        return BridgeStatus.PASS.string;
    }

    private String getBridgeSuccessOrFailure(String moving) {
        if (bridge.get(currentIndex).equals(moving)) {
            return BridgeStatus.SUCCESS.string;
        }
        return BridgeStatus.FAILURE.string;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public String getUpBridgeToString() {
        return upBridge.toString();
    }

    public String getDownBridgeToString() {
        return downBridge.toString();
    }

    private enum BridgeStatus {
        PASS("   "), SUCCESS(" O "), FAILURE(" X "), NEXT("|");

        private final String string;

        BridgeStatus(String string) {
            this.string = string;
        }
    }
}

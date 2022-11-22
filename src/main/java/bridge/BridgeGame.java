package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int count;
    private final int bridgeSize;
    private final List<String> allBridge;
    private String nowBridgeUp;
    private String nowBridgeDown;

    public BridgeGame(List<String> allBridge) {
        count = 0;
        this.allBridge = allBridge;
        this.bridgeSize = allBridge.size();
        this.nowBridgeUp = "[";
        this.nowBridgeDown = "[";
    }

    public int getCount() {
        return count;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public String getNowBridgeUp() {
        return this.nowBridgeUp;
    }

    public String getNowBridgeDown() {
        return this.nowBridgeDown;
    }

    public void plusGameCount() {
        count += 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input, int step) {
        if (Objects.equals(input, allBridge.get(step))) {
            recordRightPath(input);
            return true;
        }
        recordWrongPath(input);
        return false;
    }

    private void recordRightPath(String input) {
        if (Objects.equals(input, "U")) {
            nowBridgeUp = nowBridgeUp.concat(" O ");
            nowBridgeDown = nowBridgeDown.concat("   ");
        }
        if (Objects.equals(input, "D")) {
            nowBridgeUp = nowBridgeUp.concat("   ");
            nowBridgeDown = nowBridgeDown.concat(" O ");
        }
    }

    private void recordWrongPath(String input) {
        if (Objects.equals(input, "U")) {
            nowBridgeUp = nowBridgeUp.concat(" X ");
            nowBridgeDown = nowBridgeDown.concat("   ");
        }
        if (Objects.equals(input, "D")) {
            nowBridgeUp = nowBridgeUp.concat("   ");
            nowBridgeDown = nowBridgeDown.concat(" X ");
        }
    }

    public void nextStepRecord() {
        nowBridgeUp = nowBridgeUp.concat("|");
        nowBridgeDown = nowBridgeDown.concat("|");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.nowBridgeUp = "[";
        this.nowBridgeDown = "[";
    }
}

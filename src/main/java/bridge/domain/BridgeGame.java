package bridge.domain;

import bridge.enums.InputKey;

import java.util.List;
import java.util.StringJoiner;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final char O_FLAG = 'O';
    private static final char X_FLAG = 'X';
    public static final int BLANK = 32;

    private final List<String> bridge;
    private final char[] upBridgeStatus;
    private final char[] downBridgeStatus;
    private int position = -1;
    private int tryCount = 1;
    private int count = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.upBridgeStatus = new char[bridge.size()];
        this.downBridgeStatus = new char[bridge.size()];
        for (int i = 0; i < bridge.size(); i++) {
            upBridgeStatus[i] = BLANK;
            downBridgeStatus[i] = BLANK;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String key) {
        String upOrDown = bridge.get(++position);
        count++;
        if (key.equals(InputKey.U.getValue())) {
            return handleUpBridge(upOrDown);
        }
        return handleDownBridge(upOrDown);
    }

    private boolean handleUpBridge(String input) {
        if (input.equals(InputKey.U.getValue())) {
            upBridgeStatus[position] = O_FLAG;
            return true;
        }
        upBridgeStatus[position--] = X_FLAG;
        return false;
    }

    private boolean handleDownBridge(String input) {
        if (input.equals(InputKey.D.getValue())) {
            downBridgeStatus[position] = O_FLAG;
            return true;
        }
        downBridgeStatus[position--] = X_FLAG;
        return false;
    }

    public int getPosition() {
        return position;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        for (int i = 0; i < bridge.size(); i++) {
            upBridgeStatus[i] = BLANK;
            downBridgeStatus[i] = BLANK;
        }
        position = -1;
        count = 0;
        tryCount++;
    }

    @Override
    public String toString() {
        StringJoiner upJoiner = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner downJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (int i = 0; i < count; i++) {
            upJoiner.add(String.valueOf(upBridgeStatus[i]));
            downJoiner.add(String.valueOf(downBridgeStatus[i]));
        }
        return upJoiner + "\n" + downJoiner;
    }
}

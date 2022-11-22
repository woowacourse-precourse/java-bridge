package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> bridge;
    int attempts;
    int nextLocation;
    GameStatus type;

    enum GameStatus {
        FAIL, SUCCESS, PROGRESS
    }

    /**
     * 게임을 처음 시작할 때 사용하는 메서드
     */
    public void init(int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
        attempts = 0;
        nextLocation = 0;
        type = GameStatus.PROGRESS;
    }

    /**
     * 사용자가 이동한 칸이 움직일 수 있는 칸인지 확인할 때 사용하는 메서드
     */
    public boolean isMovable(String command) {
        return command.equals(bridge.get(nextLocation));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String command) {
        if (isMovable(command)) {
            nextLocation++;
            updateStatus();
            return;
        }
        type = GameStatus.FAIL;
    }

    public void updateStatus() {
        if (nextLocation == bridge.size()) {
            type = GameStatus.SUCCESS;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        attempts++;
        nextLocation = 0;
        type = GameStatus.PROGRESS;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(renderUpperRow(bridge, nextLocation));
        sb.append(renderLowerRow(bridge, nextLocation));
        return sb.toString();
    }

    public String renderUpperRow(List<String> bridge, int nextLocation) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < nextLocation; i++) {
            sb.append(getUpperRowElem(bridge, i, nextLocation));
            if (i != nextLocation - 1) sb.append("|");
        }
        sb.append("]");
        return sb.toString();
    }

    public String getUpperRowElem(List<String> bridge, int currentPos, int endPos) {
        if (bridge.size() != endPos && currentPos == endPos-1) {
            return " X ";
        }
        if (bridge.get(currentPos).equals("U")) {
            return " O ";
        }
        return "   ";
    }

    public String renderLowerRow(List<String> bridge, int nextLocation) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < nextLocation; i++) {
            sb.append(getLowerRowElem(bridge, i, nextLocation));
            if (i != nextLocation - 1) sb.append("|");
        }
        sb.append("]");
        return sb.toString();
    }

    public String getLowerRowElem(List<String> bridge, int currentPos, int endPos) {
        if (bridge.size() != endPos && currentPos == endPos-1) {
            return " X ";
        }
        if (bridge.get(currentPos).equals("D")) {
            return " O ";
        }
        return "   ";
    }
}

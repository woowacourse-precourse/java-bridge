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

        sb.append("[");
        for (int i = 0; i < nextLocation; i++) {
            if (i != nextLocation-1 && bridge.get(i).equals("U")) {
                sb.append(" O |");
            }
            if (i == nextLocation-1 && bridge.get(i).equals("U")) {
                sb.append(" O ]");
            }
            if (i == nextLocation-1 && bridge.get(i).equals("D")) {
                sb.append(" X ]");
            }
            if (i != nextLocation-1 && bridge.get(i).equals("D")) {
                sb.append("   ");
            }
        }
        sb.append("\n");

        for (int i = 0; i < Math.min(nextLocation, bridge.size()); i++) {
            if (i != nextLocation-1 && bridge.get(i) == "D") {
                sb.append(" O ");
            }
            if (i == nextLocation-1 && bridge.get(i) == "U") {
                sb.append(" X ");
            }
        }
        sb.append("\n");

        return sb.toString();
    }
}

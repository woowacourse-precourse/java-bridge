package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int position;
    private int count = 1;
    private boolean canMove;
    private final StringBuilder[] map = {new StringBuilder(), new StringBuilder()};
    private final List<String> bridge;

    BridgeGame(List<String> bridge, int position, boolean canMove) {
        this.bridge = bridge;
        this.position = position;
        this.canMove = canMove;
    }

    public boolean checkToContinue() {
        return position != bridge.size() && canMove;
    }

    public boolean checkSuccess() {
        return !canMove;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        if (bridge.get(position).equals(moving)) {
            setMap(moving, "O");
        }
        if (!bridge.get(position).equals(moving)) {
            setMap(moving, "X");
            canMove = false;
        }
        position++;
    }

    private void setMap(String moving, String match) {
        if (position != 0) {
            map[0].append("| ");
            map[1].append("| ");
        }
        if (moving.equals("U")) {
            map[0].append(match).append(" ");
            map[1].append("  ");
        }
        if (moving.equals("D")) {
            map[0].append("  ");
            map[1].append(match).append(" ");
        }
    }

    public StringBuilder getMap() {
        return new StringBuilder().append("[ ").append(map[0]).append("]\n[ ").append(map[1]).append("]");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        count++;
        position = 0;
        canMove = true;
        map[0] = new StringBuilder();
        map[1] = new StringBuilder();
        Application.playGame(this);
    }

    public StringBuilder getResult() {
        StringBuilder result = new StringBuilder();
        result.append("\n최종 게임 결과");
        result.append("[ ").append(map[0]).append("]\n[ ").append(map[1]).append("]");
        result.append("\n게임 성공 여부: ");
        if (canMove) result.append("성공");
        if (!canMove) result.append("실패");
        result.append("총 시도한 횟수: ").append(count);
        return result;
    }
}

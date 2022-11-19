package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    private String getNextPosition() {
        if (this.bridge.size() == 0) {
            throw new IndexOutOfBoundsException("[ERROR} 다리 리스트가 비었습니다.");
        }
        return this.bridge.remove(0);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String userPosition) {
        return getNextPosition().equals(userPosition);
    }

    public boolean checkArriveDestination(boolean canMove) {
        return canMove && this.bridge.size() == 0;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> retry(List<String> userPath) {
        this.bridge.add(selectOppositePosition(userPath.get(userPath.size()-1)));
        for(int position = userPath.size() - 2; position >= 0; position--) {
            this.bridge.add(userPath.get(position));
        }
        return userPath;
    }
    public String selectOppositePosition(String position) {
        if (position.equals("U")) {
            return "D";
        }
        return "U";
    }
}

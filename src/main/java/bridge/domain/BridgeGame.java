package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> moveResult = new ArrayList<>();
    private int tryCount = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> bridge, String movingSpace) {
        if (bridge.get(tryCount++).equals(movingSpace)) {
            if (movingSpace.equals("U")) {
                moveResult.add("O");
                moveResult.add(" ");
                return moveResult;
            }
            if (movingSpace.equals("D")) {
                moveResult.add(" ");
                moveResult.add("O");
                return moveResult;
            }
        }
        if (movingSpace.equals("U")) {
            moveResult.add("X");
            moveResult.add(" ");
            return moveResult;
        }
        if (movingSpace.equals("D")) {
            moveResult.add(" ");
            moveResult.add("X");
            return moveResult;
        }
        throw new IllegalStateException("[ERROR] 메소드를 잘못 사용하셨습니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> retry(String gameCommand) {
        if (gameCommand.equals("R")) {
            moveResult.clear();
            return moveResult;
        }
        if (gameCommand.equals("Q")) {
            return moveResult;
        }
        throw new IllegalStateException("[ERROR] 메소드를 잘못 사용하셨습니다.");
    }

    /**
     * 게임 실패 여부 검사할 때 사용하는 메서드
     */
    public boolean IsFailGame() {
        if (moveResult.contains("X")) {
            return true;
        }
        return false;
    }
}

package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    /**
     * move 함수의 결과를 반환하는 메서드
     */
    private List<List<String>> makeMoveResult(List<String> up, List<String> down) {
        List<List<String>> moveResult = new ArrayList<List<String>>();

        moveResult.add(up);
        moveResult.add(down);

        return moveResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(List<String> bridge, int index, String checkMove) {
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();

        if (bridge.get(index) == "U" && checkMove == "U") { up.add("O"); down.add(" "); }
        if (bridge.get(index) == "U" && checkMove == "D") { up.add("X"); down.add(" "); }
        if (bridge.get(index) == "D" && checkMove == "U") { up.add(" "); down.add("X"); }
        if (bridge.get(index) == "D" && checkMove == "D") { up.add(" "); down.add("O"); }

        return makeMoveResult(up, down);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}

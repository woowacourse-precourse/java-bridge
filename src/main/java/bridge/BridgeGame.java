package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int bridgeIndex = 0;
    private List<List<String>> wholeMoveResult = new ArrayList<List<String>>();

    /**
     * 지금까지 저장된 move() 결과를 반환하는 메서드
     */
    private List<List<String>> makeMoveResult(List<String> up, List<String> down) {
        wholeMoveResult.add(up);
        wholeMoveResult.add(down);

        return wholeMoveResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(List<String> bridge, String checkMove) {
        List<String> up = new ArrayList<>();
        List<String> down = new ArrayList<>();

        if (bridge.get(bridgeIndex).equals("U") && checkMove.equals("U")) { up.add("O"); down.add(" "); }
        if (bridge.get(bridgeIndex).equals("U") && checkMove.equals("D")) { up.add("X"); down.add(" "); }
        if (bridge.get(bridgeIndex).equals("D") && checkMove.equals("U")) { up.add(" "); down.add("X"); }
        if (bridge.get(bridgeIndex).equals("D") && checkMove.equals("D")) { up.add(" "); down.add("O"); }
        bridgeIndex = bridgeIndex + 1;

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

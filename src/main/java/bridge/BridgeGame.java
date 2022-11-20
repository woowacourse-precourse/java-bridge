package bridge;

import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int bridgeIndex;
    private List<List<String>> wholeMoveResult;

    public BridgeGame() {
        bridgeIndex = 0;

        wholeMoveResult = new ArrayList<List<String>>();
        wholeMoveResult.add(new ArrayList<String>());
        wholeMoveResult.add(new ArrayList<String>());
    }

    /**
     * 지금까지 저장된 move() 결과를 반환하는 메서드
     */
    private List<List<String>> makeMoveResult(String up, String down) {
        wholeMoveResult.get(0).add(up);
        wholeMoveResult.get(1).add(down);

        return wholeMoveResult;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<List<String>> move(List<String> bridge, String checkMove) {
        String up = "";
        String down = "";

        if (checkMove.equals("U") && bridge.get(bridgeIndex).equals("U")) { up = "O"; down = " "; }
        if (checkMove.equals("U") && bridge.get(bridgeIndex).equals("D")) { up = "X"; down = " "; }
        if (checkMove.equals("D") && bridge.get(bridgeIndex).equals("U")) { up = " "; down = "X"; }
        if (checkMove.equals("D") && bridge.get(bridgeIndex).equals("D")) { up = " "; down = "O"; }
        bridgeIndex = bridgeIndex + 1;

        return makeMoveResult(up, down);
    }

    /**
     * 반복문을 빠져나갈지 판단하는 메서드
     **/
    public Boolean checkBreak(int bridgeSize) {
        if (wholeMoveResult.get(0).contains("X") || wholeMoveResult.get(1).contains("X") || wholeMoveResult.get(0).size() == bridgeSize) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}

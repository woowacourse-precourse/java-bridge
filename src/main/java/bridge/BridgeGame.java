package bridge;

import java.util.ArrayList;
import java.util.List;
import view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static int i = 0;
    private OutputView outputView = new OutputView();
    private static List<String> moveList = new ArrayList<>();

    private boolean success = false;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move, List<String> bridge) {
        if (bridge.get(i).equals(move)) {
            success = true;
        }
        moveList.add(move);
        System.out.println(success);
        outputView.printMap(moveList, success);
        retry();
        i += 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}

package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int idx, List<String> bridgeList, int count, String input) {
        if (idx == bridgeList.size()) {
            outputView.printResult(idx - 1, bridgeList, input, count + 1, true);
            return;
        }
        String moveIn = inputView.readMoving();
        outputView.printMap(idx, bridgeList, moveIn);
        if (!Objects.equals(bridgeList.get(idx), moveIn)) {
            retry(bridgeList, idx, count, false, moveIn);
            return;
        }
        move(idx + 1, bridgeList, count, moveIn);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridgeList, int idx, int count, boolean winning, String input) {
        String regame = inputView.readGameCommand();
        if (Objects.equals(regame, "R")) move(0, bridgeList, count + 1, "");
        if (Objects.equals(regame, "Q")) outputView.printResult(idx, bridgeList, input, count + 1, winning);
    }
}

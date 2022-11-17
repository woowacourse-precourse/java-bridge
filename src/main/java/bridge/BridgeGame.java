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
    public void move(int currentIndex, List<String> bridgeList, int tryCount, String input) {
        if (currentIndex == bridgeList.size()) {
            outputView.printResult(currentIndex - 1, bridgeList, input, tryCount, true);
            return;
        }
        String moving = inputView.readMoving();
        outputView.printMap(currentIndex, bridgeList, moving);
        if (!Objects.equals(bridgeList.get(currentIndex), moving)) {
            retry(bridgeList, currentIndex, tryCount, false, moving);
            return;
        }
        move(currentIndex + 1, bridgeList, tryCount, moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> bridgeList, int currentIndex, int tryCount, boolean winning, String input) {
        String regame = inputView.readGameCommand();
        if (Objects.equals(regame, "R")) move(0, bridgeList, tryCount + 1, "");
        if (Objects.equals(regame, "Q")) outputView.printResult(currentIndex, bridgeList, input, tryCount, winning);
    }
}

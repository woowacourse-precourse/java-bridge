package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    static int tryCount = 1;
    static String input;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int currentIndex, List<String> bridgeList) {
        if (Objects.equals(currentIndex, bridgeList.size())) {
            outputView.printResult(currentIndex - 1, bridgeList, input);
            outputView.printResult(tryCount);
            return;
        }
        input = inputView.readMoving();
        outputView.printMap(currentIndex, bridgeList, input);
        if (!Objects.equals(bridgeList.get(currentIndex), input)) {
            retry(currentIndex, bridgeList);
            return;
        }
        move(currentIndex + 1, bridgeList);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(int currentIndex, List<String> bridgeList) {
        String regame = inputView.readGameCommand();
        if (Objects.equals(regame, "R")) {
            tryCount++;
            move(0, bridgeList);
        } else if (Objects.equals(regame, "Q")) {
            outputView.printResult(currentIndex, bridgeList, input);
            outputView.printResult(tryCount);
        }
    }
}

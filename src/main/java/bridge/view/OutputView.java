package bridge.view;

import bridge.commom.constant.LocationTable;
import bridge.model.BridgeHistory;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGreeting() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeHistory bridgeHistory) {
        Map<String, List<String>> history = bridgeHistory.getHistory();
        for (int index = 1; index >= 0; index--) {
            printMapByOneLine(history, index);
        }
    }

    private void printMapByOneLine(Map<String, List<String>> history, int index) {
        String key = LocationTable.getKeyWithIndex(index);
        String result = String.join(" | ", history.get(key));
        System.out.println("[ " + result + " ]");
    }
}

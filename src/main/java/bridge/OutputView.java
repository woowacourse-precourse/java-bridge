package bridge;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * @param bridge 다리
     * @param round 현재 회차
     * @param isCorrect 현재 회차의 선택이 맞았는지 여부
     */
    public void printMap(List<String> bridge, int round, boolean isCorrect) {
        Map<String, List<String>> map = convertToMap(bridge, round, isCorrect);
        printLine(map.get("upper"));
        printLine(map.get("lower"));
    }

    private void printLine(List<String> line) {
    }

    public Map<String, List<String>> convertToMap(List<String> bridge, int round, boolean isCorrect){
        return null;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

package bridge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 지도를 형식에 맞춰 출력한다.
     *
     * @param bridge    다리
     * @param round     현재 회차
     * @param isCorrect 현재 회차의 선택이 맞았는지 여부
     */
    public void printMap(List<String> bridge, int round, boolean isCorrect) {
        Map<String, List<String>> map = convertToMap(bridge, round, isCorrect);
        printLine(map.get("upper"));
        printLine(map.get("lower"));
    }

    private void printLine(List<String> line) {
        System.out.print("[");
        for (int i = 0; i < line.size() - 1; i++) {
            System.out.print(" " + line.get(i) + " ");
            System.out.print("|");
        }
        System.out.print(" " + line.get(line.size() - 1) + " ");
        System.out.print("]");
    }

    public Map<String, List<String>> convertToMap(List<String> bridge, int round, boolean isCorrect) {
        Map<String, List<String>> map = makePreviousMap(bridge, round);
        map.get("upper").add(markAccordanceInUpperLine(bridge, round, isCorrect));
        map.get("lower").add(markAccordanceInLowerLine(bridge, round, isCorrect));

        return map;
    }

    public Map<String, List<String>> makePreviousMap(List<String> bridge, int round) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> upperLine = new ArrayList<>();
        List<String> lowerLine = new ArrayList<>();

        for (int i = 0; i < round - 1; i++) {
            markAccordanceInUpperLine(upperLine, i, true);
            markAccordanceInLowerLine(lowerLine, i, true);
        }
        return map;
    }

    private String markAccordanceInUpperLine(List<String> bridge, int round, boolean isCorrect) {
        if (bridge.get(round).equals("U") && isCorrect) {
            return "O";
        }
        if (bridge.get(round).equals("D") && !isCorrect) {
            return "X";
        }
        return " ";
    }

    private String markAccordanceInLowerLine(List<String> bridge, int round, boolean isCorrect) {
        if (bridge.get(round).equals("D") && isCorrect) {
            return "O";
        }
        if (bridge.get(round).equals("U") && !isCorrect) {
            return "X";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

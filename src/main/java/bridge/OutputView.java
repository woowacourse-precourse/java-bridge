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

    /**
     * 결과를 보여주는 지도에서 한 라인을 출력한다.
     *
     * @param line 지도의 한 라인. 위 라인과 아래 라인으로 구성된다.
     */
    private void printLine(List<String> line) {
        System.out.print("[");
        for (int i = 0; i < line.size() - 1; i++) {
            System.out.print(" " + line.get(i) + " ");
            System.out.print("|");
        }
        System.out.print(" " + line.get(line.size() - 1) + " ");
        System.out.print("]\n");
    }

    /**
     * @param bridge    다리
     * @param round     현재 회차
     * @param isCorrect 현재 회차의 선택이 맞았는지 여부
     * @return 현재까지 이동한 다리의 상태를 나타내는 지도
     */
    public Map<String, List<String>> convertToMap(List<String> bridge, int round, boolean isCorrect) {
        Map<String, List<String>> map = makePreviousMap(bridge, round);
        map.get("upper").add(markAccordanceInUpperLine(bridge, round, isCorrect));
        map.get("lower").add(markAccordanceInLowerLine(bridge, round, isCorrect));

        return map;
    }

    /**
     * @param bridge 다리
     * @param round  현재 회차
     * @return 이전 회차까지 이동한 상태를 보여주는 지도
     */
    public Map<String, List<String>> makePreviousMap(List<String> bridge, int round) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("upper", new ArrayList<>());
        map.put("lower", new ArrayList<>());

        for (int i = 0; i < round; i++) {
            map.get("upper").add(markAccordanceInUpperLine(bridge, i, true));
            map.get("lower").add(markAccordanceInLowerLine(bridge, i, true));
        }

        return map;
    }

    /**
     * @param bridge    다리
     * @param round     현재 회차
     * @param isCorrect 현재 회차의 선택이 맞았는지 여부
     * @return 선택이 맞았는지를 문자로 표기. 맞을 경우 "O", 틀릴 경우 "X", 위 칸을 선택하지 않았을 경우 공백을 반환.
     */
    private String markAccordanceInUpperLine(List<String> bridge, int round, boolean isCorrect) {
        if (bridge.get(round).equals("U") && isCorrect) {
            return "O";
        }
        if (bridge.get(round).equals("D") && !isCorrect) {
            return "X";
        }
        return " ";
    }

    /**
     * @param bridge    다리
     * @param round     현재 회차
     * @param isCorrect 현재 회차의 선택이 맞았는지 여부
     * @return 선택이 맞았는지를 문자로 표기. 맞을 경우 "O", 틀릴 경우 "X", 아래 칸을 선택하지 않았을 경우 공백을 반환.
     */
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
    public void printResult(boolean clear, int count) {
        System.out.printf("\n게임 성공 여부: %s\n", doesSuccess(clear));
        System.out.printf("총 시도한 횟수: %d\n", count);
    }

    private String doesSuccess(boolean clear) {
        if (clear) {
            return "성공";
        }
        return "실패";
    }
}

package bridge;

import bridge.constant.State;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> input, List<String> answer) {
        print(input, answer, "U", "D");
        print(input, answer, "D", "U");
    }

    private void print(List<String> input, List<String> answer, String correct, String wrong) {
        Map<String, String > map = new HashMap<>();
        map.put(correct, " O ");
        map.put(wrong, " X ");
        System.out.print("[");
        printContent(input, answer, map, correct);
        System.out.print("]\n");
    }

    private void printContent(List<String> input, List<String> answer, Map<String, String> map, String correct) {
        int size = input.size();
        for (int i = 0; i < size; i++) {
            if (notCorrectPosition(input, correct, i)) {
                printBlank(size, i);
                continue;
            }
            printOX(answer.get(i), map);
            printBar(size, i);
        }
    }

    private void printOX(String s, Map<String, String> map) {
        System.out.print(map.get(s));
    }

    private void printBlank(int size, int i) {
        System.out.print("   ");
        printBar(size, i);
    }

    private boolean notCorrectPosition(List<String> input, String trg, int i) {
        return !trg.equals(input.get(i));
    }

    private void printBar(int size, int i) {
        if (i != size - 1) {
            System.out.print("|");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> input, List<String> answer, State state, int time) {
        System.out.println("최종 게임 결과");
        printMap(input, answer);
        System.out.println();
        System.out.println("게임 성공 여부: "+state.getMsg());
        System.out.println("총 시도한 횟수: "+time);
    }
}

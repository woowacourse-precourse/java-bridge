package bridge;

import bridge.constant.State;
import java.util.List;

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
        int size = input.size();
        // 윗부분 출력
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if ("U".equals(input.get(i)) && "U".equals(answer.get(i))) {
                System.out.print(" O ");
            }
            else if ("U".equals(input.get(i)) && "D".equals(answer.get(i))) {
                System.out.print(" X ");
            }
            else {
                System.out.print("   ");
            }
            if (i != size - 1) {
                System.out.print("|");
            }
        }
        System.out.print("]");
        System.out.println();

        // 아랫부분 출력
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            if ("D".equals(input.get(i)) && "D".equals(answer.get(i))) {
                System.out.print(" O ");
            }
            else if ("D".equals(input.get(i)) && "U".equals(answer.get(i))) {
                System.out.print(" X ");
            }
            else {
                System.out.print("   ");
            }
            if (i != size - 1) {
                System.out.print("|");
            }
        }
        System.out.print("]\n");
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> input, List<String> answer, State state, int time) {
        System.out.println("최종 게임 결과");
        printMap(input, answer);
        System.out.println("게임 성공 여부: "+state.getMsg());
        System.out.println("총 시도한 횟수: "+time);
    }
}

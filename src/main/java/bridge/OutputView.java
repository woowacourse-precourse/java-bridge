package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> curMap, List<String> answerMap) {
        StringBuilder upperMap = new StringBuilder("[");
        StringBuilder lowerMap = new StringBuilder("[");

        for (int i = 0; i < curMap.size(); i++) {

            if(i > 0){
                upperMap.append(" |");
                lowerMap.append(" |");
            }

            if (matchInputAndAnswer(curMap.get(i), answerMap.get(i)) == 0) {
                upperMap.append(" O");
                lowerMap.append("  ");
            } else if (matchInputAndAnswer(curMap.get(i), answerMap.get(i)) == 1) {
                upperMap.append(" X");
                lowerMap.append("  ");
            } else if (matchInputAndAnswer(curMap.get(i), answerMap.get(i)) == 2) {
                upperMap.append("  ");
                lowerMap.append(" O");
            } else if (matchInputAndAnswer(curMap.get(i), answerMap.get(i)) == 3) {
                upperMap.append("  ");
                lowerMap.append(" X");
            }
        }
        upperMap.append(" ]");
        lowerMap.append(" ]");

        System.out.println(upperMap);
        System.out.println(lowerMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    /**
     * @return 0: U 방향이면서 정답
     * 1: U 방향이면서 오답
     * 2: D 방향이면서 정답
     * 3: D 방향이면서 오답
     */
    private int matchInputAndAnswer(String input, String answer) {
        if (Objects.equals(input, "U")) {
            if (input.equals(answer)) {
                return 0;
            }
            return 1;
        }
        if (Objects.equals(input, "D")) {
            if (input.equals(answer)) {
                return 2;
            }
            return 3;
        }

        return 4;
    }
}

package bridge.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    List<String> upperMap = new ArrayList<>();
    List<String> lowerMap = new ArrayList<>();

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        String upper = String.join(" | ", upperMap);
        String lower = String.join(" | ", lowerMap);
        System.out.println("[ "+ upper + " ]");
        System.out.println("[ "+ lower + " ]");
    }

    public void extracted(String nextMove, String moveResult) {
        if(nextMove.matches("U")) {
            upperMap.add(moveResult);
            lowerMap.add(" ");
        }
        if(nextMove.matches("D")) {
            upperMap.add(" ");
            lowerMap.add(moveResult);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

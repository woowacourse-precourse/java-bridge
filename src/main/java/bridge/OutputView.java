package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String SUCCESS = "O";
    private final String UP = "U";
    private final String DOWN = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> visited, String moveDirection, String result) {
        upBridge(visited, moveDirection, result);
        downBridge(visited, moveDirection, result);
    }

    private void upBridge(List<String> visited, String moveDirection, String result) {
        System.out.println("[");
        for (String visit : visited) {
            checkEqual(visit, UP, SUCCESS);
            System.out.println("|");
        }
        checkEqual(moveDirection, UP, result);
        System.out.println("]");
    }

    private void downBridge(List<String> visited, String moveDirection, String result) {
        System.out.println("[");
        for (String visit : visited) {
            checkEqual(visit, DOWN, SUCCESS);
            System.out.println("|");
        }
        checkEqual(moveDirection, DOWN, result);
        System.out.println("]");
    }

    private void checkEqual(String visited, String moveDirection, String result) {
        if(visited.equals(moveDirection)) {
            System.out.println(result);
            return;
        }
        System.out.println(" ");
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

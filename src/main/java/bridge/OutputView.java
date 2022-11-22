package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private List<String> bridge;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userSteps) {
        printLine(userSteps, "U");
        printLine(userSteps, "D");
        System.out.println();
    }

    private void printLine(List<String> userSteps, String direction) {
        System.out.print("[");
        for (int i = 0; i < userSteps.size(); i++) {
            System.out.print(" " + getMark(userSteps, direction, i) + " ");
            if (i >= userSteps.size() - 1) {
                break;
            }
            System.out.print("|");
        }
        System.out.println("]");
    }

    private String getMark(List<String> userSteps, String direction, int index) {
        if (userSteps.get(index).equals(direction) && index == userSteps.size() - 1) {
            if (!userSteps.get(index).equals(bridge.get(index))) {
                return "X";
            }
        }
        if (userSteps.get(index).equals(direction)) {
            return "O";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> userSteps, int trial) {
        System.out.println("최종 게임 결과");
        printMap(userSteps);
        if (bridge.size() == userSteps.size() && bridge.get(bridge.size() - 1).equals(userSteps.get(bridge.size() - 1))) {
            System.out.println("게임 성공 여부: 성공");
            System.out.println("총 시도한 횟수: " + trial);
            return;
        }
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + trial);
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }
}

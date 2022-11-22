package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMapLine(List<String> userMovement, List<String> bridge, String target) {
        System.out.print("[ ");
        printOX(userMovement.get(0), bridge.get(0), target);
        for (int i = 1; i < userMovement.size(); i++) {
            System.out.print(" | ");
            printOX(userMovement.get(i), bridge.get(i), target);
        }
        System.out.println(" ]");
    }

    public void printOX(String userChoice, String bridgeStatus, String target) {
        if (userChoice.equals(target) && bridgeStatus.equals(target)) {
            System.out.print("O");
        }
        if (userChoice.equals(target) && !bridgeStatus.equals(target)) {
            System.out.print("X");
        }
        if (!userChoice.equals(target)) {
            System.out.print(" ");
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userMovement, List<String> bridge, int bridgeSize) {
        printMapLine(userMovement, bridge, "U");
        printMapLine(userMovement, bridge, "D");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String success, int trials) {
        System.out.println("최종 게임 결과");

        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + trials);
    }
}

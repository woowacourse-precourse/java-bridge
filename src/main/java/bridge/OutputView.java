package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMapLine(String userMovement, String bridge, int bridgeSize, char target) {
        System.out.print("[ ");
        printOX(userMovement.charAt(0), bridge.charAt(0), target);
        for (int i = 1; i < bridgeSize; i++) {
            System.out.print(" | ");
            printOX(userMovement.charAt(i), bridge.charAt(i), target);
        }
        System.out.println(" ]");
    }
    public void printOX(char userChoice, char bridgeStatus, char target) {
        if(userChoice == target && bridgeStatus == target) {
            System.out.print("O");
        }
        if(userChoice == target && bridgeStatus != target) {
            System.out.print("X");
        }
        if(userChoice != target) {
            System.out.print(" ");
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String userMovement, String bridge, int bridgeSize) {
        printMapLine(userMovement, bridge, bridgeSize, 'U');
        printMapLine(userMovement, bridge, bridgeSize, 'D');
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String success, int trials) {
        System.out.println("게임 성공 여부: " + success);
        System.out.println("총 시도한 횟수: " + trials);
    }
}

package bridge.View;

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
    public static void printMap(List<String> moveOutput) {
        printFirstLine(moveOutput);
        printSecondLine(moveOutput);
    }

    public static void printFirstLine(List<String> moveOutput) {
        System.out.print("[ ");
        for (int i = 0; i < moveOutput.size(); i++) {
            if (i % 2 == 0) {
                System.out.print(moveOutput.get(i));
                if ((moveOutput.size() != 2) && ((i+2) != moveOutput.size())) {
                    System.out.print(" | ");
                }
            }
        }
        System.out.println(" ]");
    }

    public static void printSecondLine(List<String> moveOutput) {
        System.out.print("[ ");
        for (int i = 0; i < moveOutput.size(); i++) {
            if (i % 2 == 1) {
                System.out.print(moveOutput.get(i));
                if ((moveOutput.size() != 2) && ((i+1) != moveOutput.size())) {
                    System.out.print(" | ");
                }
            }
        }
        System.out.println(" ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}

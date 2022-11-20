package bridge;

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
    public static void printMap(List<String> printBridge, int n, int i) {

        for (int j = 0; j < printBridge.size(); j++) {
            if (j==0) {
                System.out.print("[ " + printBridge.get(j) + " ");
            }
            if (j > 0) {
                System.out.print("| " + printBridge.get(j) + " ");
            }
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> upperBridge, List<String> lowerBridge, int n, int i) {
        printMap(upperBridge, n, i);
        printMap(lowerBridge, n, i);

    }

    public static String isGameSuccess(boolean checkSuccess) {
        if (checkSuccess) {
            return "성공";
        }
        return "실패";
    }
}

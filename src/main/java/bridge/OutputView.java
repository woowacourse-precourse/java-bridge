package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("");
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> upperBridge, List<String> lowerBridge) {
        System.out.print("[ ");
        System.out.print(printUpper(upperBridge));
        System.out.print(" ]\n");
        System.out.print("[ ");
        System.out.print(printLower(lowerBridge));
        System.out.print(" ]\n");
    }

    public static String printUpper(List<String> upperBridge) {
        String result = String.join(" | ", upperBridge);
        return result;
    }

    public static String printLower(List<String> lowerBridge) {
        String result = String.join(" | ", lowerBridge);
        return result;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame) {
        if (printWinOrLose(bridgeGame).equals("성공")) {
            System.out.println("");
        }
        System.out.print("최종 게임 결과\n");
        printMap(bridgeGame.upperBridge, bridgeGame.lowerBridge);
        System.out.println("");
        System.out.print("게임 성공 여부: ");
        System.out.println(printWinOrLose(bridgeGame));
        System.out.print("총 시도한 횟수: ");
        System.out.print(bridgeGame.attempt);
    }

    public static String printWinOrLose(BridgeGame bridgeGame) {
        int bridgeIndex = bridgeGame.bridgeIndex - 1;

        if (bridgeGame.upperBridge.get(bridgeIndex).equals("X")) {
            return "실패";
        }
        if (bridgeGame.lowerBridge.get(bridgeIndex).equals("X")) {
            return "실패";
        }
        return "성공";
    }
}

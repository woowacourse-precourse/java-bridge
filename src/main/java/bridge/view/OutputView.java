package bridge.view;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void printMessageForBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public static void printMessageForMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printMessageForTermination() { System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"); }

    public static void printErrorMessage(String e) { System.out.println(e); }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    /** success: 0 -> down 성공, 1 -> down 실패, 2 -> up 성공, 3 -> up 실패 **/
    public static void printMap(List<Integer> movingSuccess) {
        List<String> upPrintChecker = Arrays.asList("   ", "   ", " O ", " X ");
        List<String> downPrintChecker = Arrays.asList(" O ", " X ", "   ", "   ");
        System.out.println("[" + createBridge(movingSuccess, upPrintChecker) + "]");
        System.out.println("[" + createBridge(movingSuccess, downPrintChecker) + "]");
    }

    private static String createBridge(List<Integer> movingSuccess, List<String> printChecker){
        String printBridge = "";
        for (int indexOfBridge = 0; indexOfBridge < movingSuccess.size(); indexOfBridge++){
            printBridge = printBridge + printChecker.get(movingSuccess.get(indexOfBridge));
            if (indexOfBridge != movingSuccess.size()-1) {
                printBridge += "|";
            }
        }
        return printBridge;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<Integer> movingSuccess, int numberOfAttempts) {
        System.out.println("최종 게임 결과");
        printMap(movingSuccess);
        System.out.println("\n게임 성공 여부: " + checkFinalResult(movingSuccess));
        System.out.println("총 시도한 횟수: " + numberOfAttempts);
    }

    private static String checkFinalResult(List<Integer> movingSuccess) {
        if ((movingSuccess.get(movingSuccess.size() - 1) == 0) || (movingSuccess.get(movingSuccess.size() - 1) == 2))
            return "성공";
        return "실패";
    }
}

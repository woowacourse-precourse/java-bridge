package bridge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void printMessageForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printMessageForMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printMessageForTermination() { System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"); }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    /** success: 0 -> down 성공, 1 -> down 실패, 2 -> up 성공, 3 -> up 실패 **/
    public static boolean printMap(List<Integer> movingSuccess) {
        List<String> upPrintChecker = Arrays.asList("   ", "   ", " O ", " X ");
        List<String> downPrintChecker = Arrays.asList(" O ", " X ", "   ", "   ");
        String upBridge = createBridge(movingSuccess, upPrintChecker);
        String downBridge = createBridge(movingSuccess, downPrintChecker);
        System.out.println("[" + upBridge + "]");
        System.out.println("[" + downBridge + "]");
        return checkResult(movingSuccess);
    }

    private static String createBridge(List<Integer> movingSuccess, List<String> PrintChecker){
        String printBridge = "";
        for (int i = 0; i < movingSuccess.size(); i++){
            printBridge = printBridge + PrintChecker.get(movingSuccess.get(i));
            if (i != movingSuccess.size()-1) {
                printBridge += "|";
            }
        }
        return printBridge;
    }

    private Map<String, Object> createUpMovingChecker() {
        Map<String, Object> movingChecker = new HashMap<>();
        movingChecker.put("U", " O ");
        movingChecker.put("D", "   ");
        return  movingChecker;
    }

    private Map<String, Object> createDownMovingChecker() {
        Map<String, Object> movingChecker = new HashMap<>();
        movingChecker.put("U", "   ");
        movingChecker.put("D", " O ");
        return  movingChecker;
    }

    private static boolean checkResult(List<Integer> movingSuccess) {
        return movingSuccess.get(movingSuccess.size() - 1) == 0 || movingSuccess.get(movingSuccess.size() - 1) == 2;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<Integer> movingSuccess, int numberOfAttempts) {
        System.out.println("최종 게임 결과");
        boolean result = printMap(movingSuccess);
        System.out.println("게임 성공 여부: " + SuccessOrFailure(result));
        System.out.println("총 시도한 횟수: " + numberOfAttempts);
    }

    private static String SuccessOrFailure(boolean result) {
        if (result) {
            return "성공";
        }
        return "실패";
    }
}

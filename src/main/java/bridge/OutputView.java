package bridge;

import java.util.Collections;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void printResult(List<String> userBridge, boolean restart, int retryCount) {
        System.out.println("최종 게임 결과");
        printMap(userBridge, restart);
        if (!restart) {
            printFailedResult(retryCount);
            return;
        }
        printSuccessResult(retryCount);
    }

    public static void printMap(List<String> userBridge, boolean restart) {
        printUpStairs(userBridge, restart);
        printDownStairs(userBridge, restart);
    }

    public static void printDownStairs(List<String> userBridge, boolean restart) {
        int index;
        System.out.print("[");
        for (index = 0; index < userBridge.size(); index++) {
            printXDown(index, userBridge, restart);
            printEdge(index, userBridge);
        }
        System.out.println("]");
        System.out.println();
    }

    public static void printXDown(int index, List<String> userBridge, boolean restart) {
        if (index == userBridge.size() - 1) {
            if (!restart && userBridge.get(index).equals("D")) {
                System.out.print(" X ");
                return;
            }
        }
        printCircle(index, userBridge, "D");
    }


    public static void printUpStairs(List<String> userBridge, boolean restart) {
        int index;
        System.out.print("[");
        for (index = 0; index < userBridge.size(); index++) {
            printXUp(index, userBridge, restart);
            printEdge(index, userBridge);
        }
        System.out.println("]");
    }

    public static void printXUp(int index, List<String> userBridge, boolean restart) {
        if (index == userBridge.size() - 1) {
            if (!restart && userBridge.get(index).equals("U")) {
                System.out.print(" X ");
                return;
            }
        }
        printCircle(index, userBridge, "U");
    }

    public static void printCircle(int index, List<String> userBridge, String UpDown) {
        if (userBridge.get(index).equals(UpDown)) {
            System.out.print(" O ");
            return;
        }
        System.out.print("   ");
    }

    public static void printEdge(int index, List<String> userBridge) {
        if (index < userBridge.size() - 1) {
            System.out.print("|");
        }
    }


    public static void printFailedResult(int countGame) {
        System.out.println("게임 성공 여부: 실패");
        System.out.println("총 시도한 횟수: " + countGame);
    }

    public static void printSuccessResult(int countGame) {
        System.out.println("게임 성공 여부: 성공");
        System.out.println("총 시도한 횟수: " + countGame);
    }

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void printInputBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public static void printInputMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void printInputGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    public void printExceptionMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }
}
package bridge.view;

import bridge.domain.Status;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static void messageGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void messageLengthInput() {
        System.out.println("\n다리의 길이를 입력해주세요.");
    }

    public static void messageMovingInput() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public static void messageRetryInput() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> movings, boolean status) {
        System.out.println("[ " + makeUpperRow(movings, status) + " ]");
        System.out.println("[ " + makeLowerRow(movings, status) + " ]");
    }

    private static String makeUpperRow(List<String> movings, boolean status) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < movings.size() - 1; i++) {
            String value = movings.get(i);
            row.add(compareUpperPosition(value));
        }
        row.add(compareLastUpper(movings.get(movings.size() - 1), status));
        return String.join(" | ", row);
    }

    private static String compareUpperPosition(String value) {
        if (value.equals("U")) {
            return "O";
        }
        return " ";
    }

    private static String compareLastUpper(String value, boolean status) {
        if (!status && value.equals("U")) {
            return "X";
        }
        if (value.equals("U")) {
            return "O";
        }
        return " ";
    }

    private static String makeLowerRow(List<String> movings, boolean status) {
        List<String> row = new ArrayList<>();
        for (int i = 0; i < movings.size() - 1; i++) {
            String value = movings.get(i);
            row.add(compareLowerPosition(value));
        }
        row.add(compareLastLower(movings.get(movings.size() - 1), status));
        return String.join(" | ", row);
    }

    private static String compareLowerPosition(String value) {
        if (value.equals("D")) {
            return "O";
        }
        return " ";
    }

    private static String compareLastLower(String value, boolean status) {
        if (!status && value.equals("D")) {
            return "X";
        }
        if (value.equals("D")) {
            return "O";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> movings, boolean status, int tryCount) {
        messageFinalResult();
        printMap(movings, status);
        printIsSuccess(status);
        printTryCount(tryCount);
    }

    private static void messageFinalResult() {
        System.out.println("\n최종 게임 결과");
    }

    private static void printIsSuccess(boolean status) {
        System.out.println("\n게임 성공 여부: " + Status.convertCheckToMessage(status));
    }

    private static void printTryCount(int tryCount) {
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}

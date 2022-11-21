package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String ERROR_FLAG = "[ERROR] ";
    private static final String ENTER_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String MOVE_SUCCUESS = "O";
    private static final String MOVE_FAIL = "X";

    public static void startBridgeGame() {
        System.out.println(START_MESSAGE);
        printNewLine();
    }

    public static void readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE_MESSAGE);
    }

    public static void printError(String message) {
        System.out.println(ERROR_FLAG + message);
        printNewLine();
    }

    public static void readMoving() {
        System.out.println(MOVE_MESSAGE);
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> movingHistory, boolean moveSuccess) {
        printMoving("U", movingHistory, moveSuccess);
        printMoving("D", movingHistory, moveSuccess);
    }

    private static void printMoving(String upOrDown, List<String> movingHistory,
            boolean moveSuccess) {
        System.out.print("[ ");
        for (int i = 0; i < movingHistory.size() - 1; i++) {
            printMovingHistory(upOrDown, movingHistory.get(i));
            System.out.print(" | ");
        }
        String lastMoving = movingHistory.get(movingHistory.size() - 1);
        printMovingLast(upOrDown, lastMoving, moveSuccess);
        System.out.println(" ]");
    }

    private static void printMovingHistory(String upOrDown, String moving) {
        if (moving.equals(upOrDown)) {
            System.out.print(MOVE_SUCCUESS);
            return;
        }
        System.out.print(" ");
    }

    private static void printMovingLast(String upOrDown, String lastMoving, boolean moveSuccess) {
        if (lastMoving.equals(upOrDown)) {
            System.out.print(convertMoveSuccessToString(moveSuccess));
            return;
        }
        System.out.print(" ");
    }

    public static String convertMoveSuccessToString(boolean moveSuccess) {
        if (moveSuccess) {
            return MOVE_SUCCUESS;
        }
        return MOVE_FAIL;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }

    private static void printNewLine() {
        System.out.println();
    }
}

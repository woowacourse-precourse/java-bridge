package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";

    private static final String BLANK_1 = "   ";
    private static final String BLANK_2 = "|   ";
    private static final String CORRECT_1 = " O ";
    private static final String CORRECT_2 = "| O ";
    private static final String NOT_CORRECT_1 = " X ";
    private static final String NOT_CORRECT_2 = "| X ";

    private static String leftBridge = "";
    private static String rightBridge = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String printMap(List<String> bridge, String inputMove, int count) {
        if (inputMove.equals("U")) {
            leftBridge += printLeftBridge(bridge, count, inputMove);
            return "[" + leftBridge + "]\n" + "[" + rightBridge + "]";
        }
        rightBridge += printRightBridge(bridge, count, inputMove);
        return "[" + leftBridge + "]\n" + "[" + rightBridge + "]";
    }

    private static String printLeftBridge(List<String> bridge, int count, String inputMove) {
        if (count == 0) {
            rightBridge += BLANK_1;
            if (bridge.get(count).equals(inputMove)) {
                return CORRECT_1;
            }
            return NOT_CORRECT_1;
        }
        rightBridge += BLANK_2;
        if (bridge.get(count).equals(inputMove)) {
            return CORRECT_2;
        }
        return NOT_CORRECT_2;
    }

    private static String printRightBridge(List<String> bridge, int count, String inputMove) {
        if (count == 0) {
            leftBridge += BLANK_1;
            if (bridge.get(count).equals(inputMove)) {
                return CORRECT_1;
            }
            return NOT_CORRECT_1;
        }
        leftBridge += BLANK_2;
        if (bridge.get(count).equals(inputMove)) {
            return CORRECT_2;
        }
        return NOT_CORRECT_2;
    }

    public static void reset() {
        leftBridge = "";
        rightBridge = "";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static String printResult(boolean successGame, int retryCount) {
        return "null";
    }
}

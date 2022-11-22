package bridge.view;

import bridge.model.GameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String RESULT_TITLE = "최종 게임 결과";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String GAME_SUCCESS_MESSAGE_FORMAT = "게임 성공 여부: %s\n";
    private static final String NUMBER_OF_ATTEMPTS_FORMAT = "총 시도한 횟수: %d\n";
    public static final String START_OF_ROW = "[ ";
    public static final String END_OF_ROW = " ]";
    private static final String EXCEPTION_PREFIX = "[ERROR] ";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printTitle() {
        System.out.println(RESULT_TITLE);
    }

    public void printEndMessageForSuccess() {
        System.out.printf(GAME_SUCCESS_MESSAGE_FORMAT, SUCCESS);
    }

    public void printEndMessageForFailure() {
        System.out.printf(GAME_SUCCESS_MESSAGE_FORMAT, FAIL);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> currentPath) {
        for (int i = 0; i < 2; i++) {
            printOneRow(currentPath.get(i));
        }
        System.out.println();
    }

    private void printOneRow(String rowOfBridge) {
        printStartOfRow();
        printNodesWithSeparator(rowOfBridge);
        printEndOfRow();
    }

    private void printNodesWithSeparator(String rowOfBridge) {
        char[] row = rowOfBridge.toCharArray();
        System.out.print(row[0]);
        for (int j = 1; j < row.length; j++) {
            System.out.printf(" | %c", row[j]);
        }
    }

    private void printEndOfRow() {
        System.out.println(END_OF_ROW);
    }

    private void printStartOfRow() {
        System.out.print(START_OF_ROW);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResult result) {
        printTitle();
        printMap(result.map);
        printEndMessage(result);
        printNumberOfAttempts(result.numberOfAttempts);
    }

    private void printEndMessage(GameResult result) {
        if (result.succeed) {
            printEndMessageForSuccess();
            return;
        }
        printEndMessageForFailure();
    }

    private void printNumberOfAttempts(int attempts) {
        System.out.printf(NUMBER_OF_ATTEMPTS_FORMAT, attempts);
    }

    public static void printExceptionMessageForInvalidInput(IllegalArgumentException e) {
        System.out.println(EXCEPTION_PREFIX + e.getMessage());
    }

}

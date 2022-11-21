package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_GAME = "다리 건너기 게임을 시작합니다.\n";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String END_RESULT = "최종 게임 결과";
    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";
    private static final String PRINT_SUCCESS_RESULT = "게임 성공 여부: 성공";
    private static final String PRINT_FAIL_RESULT = "게임 성공 여부: 실패";
    private static final String PRINT_TRY_COUNT = "총 시도한 횟수: ";
    private static final int FIRST_LINE_INDEX = 0;
    private static final int SECOND_LINE_INDEX = 1;

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> map) {
        System.out.print(LEFT_BRACKET);
        map.forEach(OutputView::printFirstLine);
        System.out.println(RIGHT_BRACKET);
        System.out.print(LEFT_BRACKET);
        map.forEach(OutputView::printSecondLine);
        System.out.println(RIGHT_BRACKET);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> map, String status, int tryCount) {
        System.out.println(END_RESULT);
        printMap(map);
        if (status.equals(SUCCESS)) {
            System.out.println(PRINT_SUCCESS_RESULT);
        }
        if (status.equals(FAIL)) {
            System.out.println(PRINT_FAIL_RESULT);
        }
        System.out.println(PRINT_TRY_COUNT + tryCount);
    }

    public void printError(String error) {
        System.out.println(ERROR_MESSAGE + error);
    }

    private static void printFirstLine(List<String> map) {
        System.out.print(map.get(FIRST_LINE_INDEX));
    }

    private static void printSecondLine(List<String> map) {
        System.out.print(map.get(SECOND_LINE_INDEX));
    }
}

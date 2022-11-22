package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

import java.util.List;

/**
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class OutputView {
    private final static String RESULT_START_BRACKET = "[";
    private final static String RESULT_END_BRACKET = "]";
    private final static String DELIMITER = "|";
    private final static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final static String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private final static String GAME_CHECK_SUCCESS_MESSAGE = "게임 성공 여부: %s";
    private final static String GAME_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";
    private final static String LINE_BREAK = System.lineSeparator();

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE + LINE_BREAK);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> map) {
        System.out.println(RESULT_START_BRACKET + String.join(DELIMITER, map.get(0)) + RESULT_END_BRACKET);
        System.out.println(RESULT_START_BRACKET + String.join(DELIMITER, map.get(1)) + RESULT_END_BRACKET + LINE_BREAK);

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> map, boolean gameResult, int tryCount) {
        String result = "실패";
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(map);
        if (gameResult) {
            result = "성공";
        }
        System.out.printf(GAME_CHECK_SUCCESS_MESSAGE + LINE_BREAK, result);
        System.out.printf(GAME_TRY_COUNT_MESSAGE, tryCount);
    }
}

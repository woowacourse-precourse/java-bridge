package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    private static final String INPUT_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_END_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: %s";
    private static final String GAME_TRY_COUNT_MESSAGE = "\n총 시도한 횟수: %d";

    /**
     * 게임 시작 메시지를 출력한다.
     */
    public void printStartMessage() {
        System.out.println(INPUT_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(String userPathLog) {
        System.out.print(userPathLog);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(String userPathLog, String gameResult, int tryCount) {
        System.out.println(GAME_END_MESSAGE);
        System.out.print(userPathLog);
        System.out.print(String.format(GAME_RESULT_MESSAGE + GAME_TRY_COUNT_MESSAGE, gameResult, tryCount));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printEmptyLine() {
        System.out.println();
    }
}

package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private final String FINAL_GAME_RESULT_MESSAGE = "\n최종 게임 결과\n%s\n";
    private final String SUCCESS_MESSAGE = "\n게임 성공 여부: 성공\n";
    private final String FAIL_MESSAGE = "\n게임 성공 여부: 실패\n";
    private final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCount, boolean success, String resultBridgeMap) {
        System.out.printf(FINAL_GAME_RESULT_MESSAGE, resultBridgeMap);
        String totalTryCountMessage = String.format(TOTAL_TRY_COUNT_MESSAGE, tryCount);

        if (success) {
            System.out.println(SUCCESS_MESSAGE + totalTryCountMessage);
            return;
        }

        System.out.println(FAIL_MESSAGE + totalTryCountMessage);
    }
}

package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT_OF_GAME_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: %s\n";
    private static final String TOTAL_TRIAL_MESSAGE = "총 시도한 횟수: %d\n";

    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    public void startBridgeGame() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String bridge) {
        System.out.println(bridge);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String bridge, boolean completeGame, int trial) {
        String successOrFail = getSuccessOrFail(completeGame);

        System.out.println(FINAL_RESULT_OF_GAME_MESSAGE);
        System.out.println(bridge);
        System.out.printf(SUCCESS_OR_FAIL_MESSAGE, successOrFail);
        System.out.printf(TOTAL_TRIAL_MESSAGE, trial);
    }

    private String getSuccessOrFail(boolean completeGame) {
        if (completeGame) {
            return SUCCESS;
        }
        return FAIL;
    }
}

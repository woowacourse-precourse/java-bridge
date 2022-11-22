package bridge.view;

import bridge.domain.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String INIT_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private OutputView() {
    }

    // Validator에서 예외 처리 시 errorMessage를 출력한다.
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printInit() {
        System.out.println(INIT_MESSAGE + "\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGame bridgeGame) {
        System.out.println(bridgeGame);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(BridgeGame bridgeGame, boolean isSuccess) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeGame);

        String ret = getSuccessOrFail(isSuccess);
        System.out.println(GAME_SUCCESS_OR_FAIL_MESSAGE + ret);
        System.out.println(TOTAL_TRY_COUNT_MESSAGE + bridgeGame.getTryCount());
    }

    private static String getSuccessOrFail(boolean isSuccess) {
        if (isSuccess) return SUCCESS;
        return FAIL;
    }
}

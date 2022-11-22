package bridge.view;

import bridge.domain.MoveResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    private static final String GAME_FAIL_MESSAGE = "게임 성공 여부: 실패";
    private static final String ERROR_MESSAGE = "[ERROR]";


    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MoveResult result) {
        System.out.println(result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(MoveResult moveResult) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(moveResult);
        System.out.println(getGameResultMessage(moveResult.isSuccess()));
        System.out.println(TRY_COUNT_MESSAGE + moveResult.getTryCount());
    }

    private String getGameResultMessage(boolean isSuccess) {
        if (isSuccess) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAIL_MESSAGE;
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}

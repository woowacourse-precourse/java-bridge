package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공";
    private static final String GAME_FAIL_MESSAGE = "게임 실패";
    private static final String RETRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private static String moveStateToUpperBridgeView(List<String> userMoveState) {
        return userMoveState.toString()
                .replace(",", " | ")
                .replace("D_true", " ")
                .replace("D_false", " ")
                .replace("U_true", "O")
                .replace("U_false", "X")
                .replace("[", "[ ")
                .replace("]", " ]");
    }

    private static String moveStateToLowerBridgeView(List<String> userMoveState) {
        return userMoveState.toString()
                .replace(",", " | ")
                .replace("U_true", " ")
                .replace("U_false", " ")
                .replace("D_true", "O")
                .replace("D_false", "X")
                .replace("[", "[ ")
                .replace("]", " ]");
    }

    private static String getGameResultToMessage(boolean isGameSuccess) {
        if (isGameSuccess) {
            return GAME_SUCCESS_MESSAGE;
        }
        return GAME_FAIL_MESSAGE;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userMoveState) {
        System.out.println(moveStateToUpperBridgeView(userMoveState));
        System.out.println(moveStateToLowerBridgeView(userMoveState));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> userMoveState, int retryCount, boolean isGameSuccess) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(userMoveState);
        System.out.println(GAME_RESULT_MESSAGE + getGameResultToMessage(isGameSuccess));
        System.out.println(RETRY_COUNT_MESSAGE + retryCount);
    }
}

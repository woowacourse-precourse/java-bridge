package bridge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String WHETHER_SUCCESS_MESSAGE = "게임 성공 여부: ";
    private static final String TRY_NUMBER_MESSAGE = "총 시도한 횟수: ";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        System.out.println(formatMoveStatus(bridgeGame.getMoveStatus().get("U")));
        System.out.println(formatMoveStatus(bridgeGame.getMoveStatus().get("D")));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(bridgeGame);
        if (bridgeGame.hasSucceeded()) {
            System.out.println(WHETHER_SUCCESS_MESSAGE + "성공");
        }
        if (!bridgeGame.hasSucceeded()) {
            System.out.println(WHETHER_SUCCESS_MESSAGE + "실패");
        }
        System.out.println(TRY_NUMBER_MESSAGE + bridgeGame.getRestartNumber());
    }

    public void printErrorMessage(IllegalArgumentException error) {
        System.out.println(ERROR_MESSAGE + error.getMessage());
    }

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    public void printMoveMessage() {
        System.out.println(MOVE_MESSAGE);
    }

    public void printRetryMessage() {
        System.out.println(RETRY_MESSAGE);
    }

    public void printLengthMessage() {
        System.out.println(LENGTH_MESSAGE);
    }



    private String formatMoveStatus(List<String> statusList) {
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (String status : statusList) {
            result.append(status).append(" | ");
        }
        result.replace(result.length() - 2, result.length(), "]");

        return result.toString();
    }
}

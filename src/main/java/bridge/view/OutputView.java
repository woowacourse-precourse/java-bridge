package bridge.view;

import bridge.constant.Direction;
import bridge.constant.MoveStatus;
import bridge.dto.FinishedGameResultResponse;
import bridge.util.OutputConverter;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MSG = "다리 건너기 게임을 시작합니다.\n";
    private static final String BRIDGE_SIZE_DEMAND_MSG = "다리의 길이를 입력해주세요.";
    private static final String BRIDGE_MOVE_DEMAND_MSG = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_DEMAND_MSG = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String ERROR_SUFFIX = " 다시 입력해주세요.";
    private static final String MAP_PREFIX = "[ ";
    private static final String MAP_SUFFIX = " ]";
    private static final String STRING_DELIMITER = "";
    private static final String MAP_DELIMITER = " | ";
    private static final String FINAL_RESULT_HEADER = "최종 게임 결과";
    private static final String SUCCESS_RESULT_MSG = "게임 성공 여부: 성공";
    private static final String FAIL_RESULT_MSG = "게임 성공 여부: 실패";
    private static final String PLAY_COUNT_PREFIX = "총 시도한 횟수: ";


    public static void printError(String errorMsg) {
        System.out.println(ERROR_PREFIX + errorMsg + ERROR_SUFFIX);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final List<MoveStatus> moveStatuses) {
        List<String> bridges = OutputConverter.resultToStrings(moveStatuses);

        System.out.println(MAP_PREFIX + toPrintForm(bridges.get(Direction.UPSIDE.ordinal())) + MAP_SUFFIX);
        System.out.println(MAP_PREFIX + toPrintForm(bridges.get(Direction.DOWNSIDE.ordinal())) + MAP_SUFFIX);
        System.out.println();
    }

    private String toPrintForm(String bridge) {
        return String.join(MAP_DELIMITER, bridge.split(STRING_DELIMITER));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(final FinishedGameResultResponse response) {
        printResultHeader();
        printMap(response.getStatuses());
        printSuccessState(response.isSuccess());
        printPlayCount(response.getPlayCount());
    }

    private void printResultHeader() {
        System.out.println(FINAL_RESULT_HEADER);
    }

    private void printSuccessState(final boolean isSuccess) {
        if (isSuccess) {
            System.out.println(SUCCESS_RESULT_MSG);
            return;
        }
        System.out.println(FAIL_RESULT_MSG);
    }

    private void printPlayCount(final int playCount) {
        System.out.println(PLAY_COUNT_PREFIX + playCount);
    }

    public void printStart() {
        System.out.println(GAME_START_MSG);
        System.out.println(BRIDGE_SIZE_DEMAND_MSG);
    }

    public void printOrder() {
        System.out.println(BRIDGE_MOVE_DEMAND_MSG);
    }

    public void printRetry() {
        System.out.println(RETRY_DEMAND_MSG);
    }

    public void printNewLine() {
        System.out.println();
    }
}

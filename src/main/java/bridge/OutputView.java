package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 */
public class OutputView {
    private static final String START_EVENT_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_SIZE_EVENT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVE_EVENT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_EVENT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String GAME_RESULT_TITLE = "최종 게임 결과";
    private static final String GAME_RESULT_EVENT_MESSAGE = "게임 성공 여부: $gameResult\n총 시도한 횟수: $tryCount\n";
    private static final String REPLACE_GAME_RESULT_FROM = "$gameResult";
    private static final String REPLACE_TRY_COUNT_FROM = "$tryCount";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> map) {
        System.out.println(map.get(BridgeStatus.UP.getStatusNumber()));
        System.out.println(map.get(BridgeStatus.DOWN.getStatusNumber()));
        printBlankLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(
            List<String> map,
            int tryCount,
            boolean isCorrectPath) {
        String gameResult = successOrFail(isCorrectPath);

        System.out.println(GAME_RESULT_TITLE);
        printMap(map);
        printGameResultEventMessage(gameResult, tryCount);
    }

    private String successOrFail(boolean isCorrectPath) {
        if (isCorrectPath) {
            return SUCCESS;
        }
        return FAIL;
    }

    private void printGameResultEventMessage(String gameResult, int tryCount) {
        System.out.println(GAME_RESULT_EVENT_MESSAGE
                .replace(REPLACE_GAME_RESULT_FROM, gameResult)
                .replace(REPLACE_TRY_COUNT_FROM, Integer.toString(tryCount)));
    }

    public void printStartEventMessage() {
        System.out.println(START_EVENT_MESSAGE);
    }

    public void printBridgeSizeEventMessage() {
        System.out.println(BRIDGE_SIZE_EVENT_MESSAGE);
    }

    public void printMoveEventMessage() {
        System.out.println(MOVE_EVENT_MESSAGE);
    }

    public void printRetryEventMessage() {
        System.out.println(RETRY_EVENT_MESSAGE);
    }

    public void printBlankLine() {
        System.out.println();
    }
}

package bridge.view;

import bridge.domain.bridge.CrossStatus;
import bridge.domain.trycount.TryCount;

import static bridge.domain.bridge.CrossStatus.SUCCESS;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_STATUS_FORMAT = "게임 성공 여부: %s\n";
    private static final String GAME_TRY_COUNT_FORMAT = "총 시도한 횟수: %d";
    private static final String EMPTY = "";
    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String map) {
        System.out.println(map);
        System.out.println(EMPTY);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(TryCount tryCount, CrossStatus status, String map) {
        System.out.println(FINAL_GAME_RESULT);
        System.out.println(map);
        System.out.printf(GAME_STATUS_FORMAT, judgeResult(status));
        System.out.printf(GAME_TRY_COUNT_FORMAT, tryCount.count());
    }

    private String judgeResult(CrossStatus status) {
        if (status == SUCCESS) {
            return GAME_SUCCESS;
        }
        return GAME_FAIL;
    }

    public void printStartMessage() {
        System.out.println(GAME_START);
    }
}

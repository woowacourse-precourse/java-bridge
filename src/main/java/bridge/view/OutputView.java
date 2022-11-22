package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.Record;
import bridge.domain.UsersRoute;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String GET_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String GET_MOVE_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GONNA_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String IS_SUCCESSED = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String TRY_COUNT = "총 시도한 횟수: ";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printGetBridgeLength() {
        System.out.println(GET_BRIDGE_LENGTH);
    }

    public void printGetMoveDirection() {
        System.out.println(GET_MOVE_DIRECTION);
    }

    public void printGetRetry() {
        System.out.println(GONNA_RETRY);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(UsersRoute usersRoute, Bridge bridge) {
        System.out.println(Record.getTopLane(usersRoute, bridge));
        System.out.println(Record.getBottomLane(usersRoute, bridge));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tryCount, boolean isSuccess) {
        if (isSuccess) {
            System.out.println(IS_SUCCESSED + SUCCESS);
            System.out.println(TRY_COUNT + tryCount);
            return;
        }
        System.out.println(IS_SUCCESSED + FAIL);
        System.out.println(TRY_COUNT + tryCount);
    }

    public void printFinalResult(UsersRoute usersRoute, Bridge bridge) {
        System.out.println(FINAL_RESULT);
        System.out.println(Record.getTopLane(usersRoute, bridge));
        System.out.println(Record.getBottomLane(usersRoute, bridge));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}

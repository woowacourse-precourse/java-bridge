package bridge.view;

import bridge.domain.Attempt;
import bridge.domain.Bridge;
import bridge.domain.Status;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String FINAL_GAME_STATUS = "게임 성공 여부: ";
    private static final String ALL_ATTEMPTS = "총 시도한 횟수: ";

    public static void printStart() {
        System.out.println(GAME_START);
    }

    public static void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public static void printInputMoving() {
        System.out.println(INPUT_MOVING);
    }

    public static void printInputCommand() {
        System.out.println(INPUT_COMMAND);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * 첫번째 행 문자열과 두번째 행 문자열을 나눠 생성한다.
     */
    public static void printMap(Bridge bridge, List<String> user) {
        System.out.println("[ " + joinByPipe(bridge.makeRow(user, "U")) + " ]");
        System.out.println("[ " + joinByPipe(bridge.makeRow(user, "D")) + " ]\n");
    }

    private static String joinByPipe(String[] status) {
        return String.join(" | ", status);
    }

    public static void printFinalGameResult() {
        System.out.println(FINAL_GAME_RESULT);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Bridge bridge, List<String> user) {
        printMap(bridge, user);
    }

    public static void printGameStatus(Status status) {
        System.out.println(FINAL_GAME_STATUS + status.getMessage());
    }

    public static void printAllAttempts(Attempt attempt) {
        System.out.println(ALL_ATTEMPTS + attempt.getAttempt());
    }
}
